package com.insurance.verificationsystem.rest;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.ehcache.Cache;
import org.ehcache.Cache.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.verificationsystem.audit.AuditRepository;
import com.insurance.verificationsystem.cache.LastUpdatedTimeProvider;
import com.insurance.verificationsystem.cache.PolicyNumbers;
import com.insurance.verificationsystem.cache.Vehicle;
import com.insurance.verificationsystem.cache.VehiclesCacheLoader;

@RestController
@RequestMapping("/manage")
public class AppManageController {

	private static final Logger logger = LoggerFactory.getLogger(AppManageController.class);

	@Autowired
	private VehiclesCacheLoader vehiclesCacheLoader;

	@Autowired
	private LastUpdatedTimeProvider lastUpdatedTimeProvider;
	@Autowired
	private Cache<String, Vehicle> vehiclesCache;
	@Autowired
	private Cache<String, PolicyNumbers> policiesCache;
	@Autowired
	private
	AuditRepository auditRepository;

	@Value("${verificationsystem.shutdown.allowed:}")
	private String shutDownIP;

	@GetMapping("/log-error")
	public String ex() {
		logger.error("Check error logging.");
		return "Check error logging.";
	}

	@GetMapping("/health-check")
	public ResponseEntity<AppState> healthCheck() {
		logger.info("Invoking health check by REST.");
		AppState appState = new AppState();
		appState.up = true;
		appState.durationFromUpdate = lastUpdatedTimeProvider.timeFromLastUpdate().getSeconds();
		return ResponseEntity.ok(appState);
	}

	@GetMapping("/health-check/simple")
	public ResponseEntity<String> summaryHealthCheck() {
		if (!vehiclesCache.iterator().hasNext()) {
			return ResponseEntity.ok("no data");
		}
		if (!policiesCache.iterator().hasNext()) {
			return ResponseEntity.ok("no data");
		}
		if (Math.abs(lastUpdatedTimeProvider.timeFromLastUpdate().getSeconds()) > 60 * 60 * 48) {
			return ResponseEntity.ok("service stale");
		}
		return ResponseEntity.ok("service up");
	}
	@GetMapping("/health-check/up")
	public ResponseEntity<String> appUpCheck() {
		if (!vehiclesCache.iterator().hasNext()) {
			return ResponseEntity.ok("no data");
		}
		return ResponseEntity.ok("service up");
	}

	@GetMapping("/reload-vehicles")
	public ResponseEntity<String> reloadCache() {
		logger.info("Invoking reloading cache by REST.");
		return vehiclesCacheLoader.reload() ? ResponseEntity.ok("Cache reloaded")
				: ResponseEntity.status(INTERNAL_SERVER_ERROR).body("Cache NOT reloaded");
	}

	@PostMapping("/reload-vehicles")
	public ResponseEntity<String> loadCache(@RequestBody List<Vehicle> vehicles) {
		logger.info("Invoking reloading cache by REST.");
		try {
			vehiclesCacheLoader.load(vehicles);
			return ResponseEntity.ok("Cache reloaded");
		} catch (Exception e) {
			return ResponseEntity.status(INTERNAL_SERVER_ERROR).body("Cache NOT reloaded");
		}
	}

	@GetMapping("/list-vehicles")
	public ResponseEntity<List<Vehicle>> listVeh() {
		Iterator<Entry<String, Vehicle>> iter = vehiclesCache.iterator();
		List<Vehicle> vehicles = new ArrayList<>();
		while (iter.hasNext()) {
			vehicles.add(iter.next().getValue());
		}
		return ResponseEntity.ok(vehicles);
	}
	

	/*@GetMapping("/list-request")
	public ResponseEntity<List<Vehicle>> listRequestHistory() {
		Iterator<Entry<String, Vehicle>> iter = auditRepository.
		List<Vehicle> vehicles = new ArrayList<>();
		while (iter.hasNext()) {
			vehicles.add(iter.next().getValue());
		}
		return ResponseEntity.ok(vehicles);
	}*/

	@Autowired
	private ApplicationContext context;

	@PostMapping("/shutdown")
	public void shutdownContext(HttpServletRequest request) {
		String addr = request.getRemoteAddr();
		logger.warn("Shutdown requested from " + addr);
		if (addr.length() > 0 && shutDownIP.contains(addr)) {
			logger.warn("Shutting down");
			((ConfigurableApplicationContext) context).close();
		} else {
			logger.error("Shut down request denied from " + addr);
		}
	}

	public static class AppState {
		public boolean up;
		public long durationFromUpdate;
	}

}
