package com.insurance.verificationsystem.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

@JdbcTest
@RunWith(SpringRunner.class)
public class VehicleRepositoryTest {

    private static final String DB_VEHS = "select * from Vehicle LIMIT ? OFFSET ?";
    private static final String DB_VEH_COUNT = "SELECT count(*) FROM Vehicle";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private VehicleRepository vehicleRepository;

    @Test
    public void checkVehicle() {
        vehicleRepository = new VehicleRepository(jdbcTemplate, DB_VEHS, DB_VEH_COUNT, 100);
        Vehicle value = vehicleRepository.getValues().next().get(0);

        Vehicle expected = new Vehicle();
        expected.setId(1);
        expected.setPolicyNumber("A1000");
        expected.setVin("AB101CD");
        expected.setRemoved(false);
        expected.setEffectiveDate(LocalDateTime.of(2018, 1, 1, 0, 0, 0));
        expected.setExpireDate(LocalDateTime.of(2018, 5, 20, 0, 0, 0));

        assertEquals(expected, value);
    }

    @Test
    public void readAllAtOnce() {
        vehicleRepository = new VehicleRepository(jdbcTemplate, DB_VEHS, DB_VEH_COUNT, 100);
        Iterator<List<Vehicle>> values = vehicleRepository.getValues();

        assertTrue(values.hasNext());
        List<Vehicle> vehicles = values.next();
        assertEquals(4, vehicles.size());
        assertFalse(values.hasNext());
    }

    @Test
    public void readAllSeveralTimes() {
        vehicleRepository = new VehicleRepository(jdbcTemplate, DB_VEHS, DB_VEH_COUNT, 2);
        Iterator<List<Vehicle>> values = vehicleRepository.getValues();

        assertTrue(values.hasNext());
        List<Vehicle> vehicles = values.next();
        assertEquals(2, vehicles.size());

        assertTrue(values.hasNext());
        vehicles = values.next();
        assertEquals(2, vehicles.size());

        assertFalse(values.hasNext());
    }


}
