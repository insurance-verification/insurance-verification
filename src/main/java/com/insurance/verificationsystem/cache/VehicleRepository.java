package com.insurance.verificationsystem.cache;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Iterator;
import java.util.List;

public class VehicleRepository implements CacheValuesProvider<Vehicle> {

    private final JdbcTemplate jdbcTemplate;
    private final int batchSize;
    private final String vehicleQuery;
    private final String vehicleCountQuery;

    private RowMapper<Vehicle> rowMapper = new BeanPropertyRowMapper<>(Vehicle.class);

    public VehicleRepository(JdbcTemplate jdbcTemplate, String vehicleQuery, String vehicleCountQuery, int batchSize) {
        if(batchSize < 0) {
            throw new IllegalArgumentException("Read batch size must be more than zero!");
        }
        this.jdbcTemplate = jdbcTemplate;
        this.batchSize = batchSize;
        this.vehicleQuery = vehicleQuery;
        this.vehicleCountQuery = vehicleCountQuery;
    }

    @Override
    public Iterator<List<Vehicle>> getValues() {
        Integer count = jdbcTemplate.queryForObject(vehicleCountQuery, Integer.class);
        return new Iterator<List<Vehicle>>() {
            private Integer currentPage = 0;
            @Override
            public boolean hasNext() {
                return currentPage*batchSize < count;
            }
            @Override
            public List<Vehicle> next() {
                if(!hasNext()) {
                    throw new IllegalStateException();
                }
                currentPage++;
                return jdbcTemplate.query(vehicleQuery, 
                        new Object[]{batchSize,(currentPage - 1)*batchSize},
                        rowMapper);
            }
        };
    }

}