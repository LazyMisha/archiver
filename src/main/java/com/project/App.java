package com.project;

import com.project.exception.WrongZipFileException;
import com.project.service.CommandExecutor;
import com.project.service.ConsoleHelper;
import com.project.service.Operation;
import com.project.utils.TextManager;

import java.io.IOException;
import java.util.Locale;

public class App {

    public static void main(String[] args) {

        do {
            try {
                askLanguage();
                break;
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Please type '0' or '1'.");
            }
        } while (true);

        Operation operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeErrorMessage(TextManager.getText("wrong_file"));
            } catch (Exception e) {
                ConsoleHelper.writeErrorMessage(TextManager.getText("wrong_input"));
            }

        } while (operation != Operation.EXIT);
    }


    private static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("\n" + TextManager.getText("choose_operation"));
        ConsoleHelper.writeMessage(String.format("\t %d - " + TextManager.getText("pack_files_operation"), Operation.CREATE.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - " + TextManager.getText("add_file_operation"), Operation.ADD.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - " + TextManager.getText("remove_file_option"), Operation.REMOVE.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - " + TextManager.getText("extract_archive_operation"), Operation.EXTRACT.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - " + TextManager.getText("check_files_operation"), Operation.CONTENT.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - " + TextManager.getText("exit_operation"), Operation.EXIT.ordinal()));
        return Operation.values()[ConsoleHelper.readInt()];
    }

    private static void askLanguage() throws IOException {
        ConsoleHelper.writeMessage("\nChoose language:");
        ConsoleHelper.writeMessage(String.format("\t %d - English language", 0));
        ConsoleHelper.writeMessage(String.format("\t %d - Русский язык", 1));
        if (ConsoleHelper.readInt() == 1) {
            Locale.setDefault(new Locale("ru", "RU"));
        } else {
            Locale.setDefault(new Locale("en", "US"));
        }
        ConsoleHelper.writeMessage(TextManager.getText("default_language"));
        ConsoleHelper.writeMessage(TextManager.getText("hello"));
    }
}