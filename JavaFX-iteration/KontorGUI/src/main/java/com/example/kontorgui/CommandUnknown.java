/* Fallback for when a command is not implemented
 */
package com.example.kontorgui;


class CommandUnknown extends BaseCommand implements Command {
  @Override
  public void execute (Context context, String name) {
    System.out.println("command unknown execute");

    System.out.println("\nHovsa, jeg tror desværre ikke, at jeg forstår " + name + "😕");
  }
}
