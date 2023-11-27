/* Baseclass for commands
 */
package com.example.kontorgui;


class BaseCommand {
  String description = "Undocumented";
  
  protected boolean guardEq (String[] parameters, int bound) {
    return parameters.length!=bound;
  }
  
  public String getDescription () {
    return description;
  }
}
