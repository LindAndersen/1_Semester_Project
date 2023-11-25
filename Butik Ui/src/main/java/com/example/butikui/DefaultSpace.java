package com.example.butikui;

interface DefaultSpace {
    void showTrash();
    boolean isCommandReachable(String name);
    String[] getCommands();
}
