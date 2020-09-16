package services;

import dao.ValueDao;
import models.Value;

public class ValueService {
    private ValueDao valueDao = new ValueDao();

    public  ValueService() {
    }

    public void saveValue(Value value) {
        valueDao.save(value);
    }

    public static void createTable() {
        ValueDao.createTable();
    }
}
