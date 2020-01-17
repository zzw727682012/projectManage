package com.example.core;

import java.util.ArrayList;
import java.util.List;

public class ConnectorManager {
    private List<Connector> connectors = new ArrayList<Connector>();
    private static volatile ConnectorManager instance;
    private static Object lock = new Object();

    private ConnectorManager() {

    }

    public static ConnectorManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new ConnectorManager();
                    return instance;
                }
            }
        }
        return instance;
    }

    public boolean addConnector(Connector connector) {
        return connectors.add(connector);
    }

    public boolean removeConnector(Connector connector) {
        return connectors.remove(connector);
    }

    public List<Connector> getConnectors() {
        return connectors;
    }
}
