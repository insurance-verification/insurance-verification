package com.insurance.verificationsystem.cache;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.ehcache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VehiclesCacheLoader {

	private static final Logger logger = LoggerFactory.getLogger(VehiclesCacheLoader.class);

	private final Cache<String, Vehicle> vehicles;
	private final Cache<String, PolicyNumbers> policies;
	private final CacheValuesProvider<Vehicle> valuesProvider;
	private final LastUpdatedTimeProvider lastUpdatedTimeProvider;

	public VehiclesCacheLoader(final Cache<String, Vehicle> vehicles, final Cache<String, PolicyNumbers> policies,
			final CacheValuesProvider<Vehicle> valuesProvider, final LastUpdatedTimeProvider lastUpdatedTimeProvider) {
		this.vehicles = requireNonNull(vehicles);
		this.policies = requireNonNull(policies);
		this.valuesProvider = requireNonNull(valuesProvider);
		this.lastUpdatedTimeProvider = lastUpdatedTimeProvider;
	}

	public boolean reload() {
		try {
			doReload();
			lastUpdatedTimeProvider.cacheUpdated();
			return true;
		} catch (final Exception e) {
			logger.error("Error when loading vehicles", e);
			return false;
		}
	}

	/**
	 * This should be able to safely 'update' the items in the cache without
	 * expiring any that might be missed. The data for vehicles should be available
	 * in the data source even after vehicles are no longer active.
	 */
	private void doReload() {
		logger.info("Start loading vehicles");
		final Iterator<List<Vehicle>> values = this.valuesProvider.getValues();
		while (values.hasNext()) {
			values.next().forEach(v -> {
				vehicles.put(v.getVin(), v);
				final String policyNumber = v.getPolicyNumber();
				final PolicyNumbers policyNumbers = new PolicyNumbers();
				policyNumbers.getPolicyNumbers().add(policyNumber);
				policies.put(policyNumber, policyNumbers);
			});
		}
		logger.info("Finish loading vehicles");
	}
	
	public List<Vehicle> load() {
		logger.info("Start loading vehicles");
		final Iterator<List<Vehicle>> values = this.valuesProvider.getValues();
		List<Vehicle> retval = new ArrayList<>();
		while (values.hasNext()) {
			retval.addAll(values.next());
		}
		logger.info("Finish loading vehicles");
		return retval;
	}

	public void load(final List<Vehicle> vehicleList) {
		logger.info("Start loading vehicles");
		vehicleList.forEach(v -> {
			vehicles.put(v.getVin(), v);
			final String policyNumber = v.getPolicyNumber();
			final PolicyNumbers policyNumbers = new PolicyNumbers();
			policyNumbers.getPolicyNumbers().add(policyNumber);
			policies.put(policyNumber, policyNumbers);
		});
		lastUpdatedTimeProvider.cacheUpdated();
		logger.info("Finish loading vehicles");
	}

}
