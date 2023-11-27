package com.example.kontorgui;

/* Command for exiting program
 */

class CommandExit extends BaseCommand implements Command {
  CommandExit() {
    this.description = "Forlad spillet";
  }
  @Override
  public void execute (Context context, String name) {

    context.makeDone();
  }
}
