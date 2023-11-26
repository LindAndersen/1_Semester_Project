package com.genbrugsstation;

interface DefaultSpace {
    void showTrash();
    boolean isCommandReachable(String name);
    String[] getCommands();
}
