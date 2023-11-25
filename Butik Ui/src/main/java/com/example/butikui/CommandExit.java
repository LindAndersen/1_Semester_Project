package com.example.butikui;/* Command for exiting program
 */

class CommandExit extends BaseCommand implements Command {
  CommandExit() {
    this.description = "Forlad spillet";
  }
  @Override
  public void execute (Context context, String command, String parameters[]) {
    context.makeDone();
  }
}
