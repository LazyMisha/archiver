package com.project.command;

import com.project.exception.PathIsNotFoundException;
import com.project.service.ConsoleHelper;
import com.project.service.ZipFileManager;
import com.project.utils.TextManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipExtractCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage(TextManager.getText("extract_archive"));

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage(TextManager.getText("type_path_to_extract"));
            Path destinationPath = Paths.get(ConsoleHelper.readString());
            zipFileManager.extractAll(destinationPath);

            ConsoleHelper.writeMessage(TextManager.getText("extract_done"));

        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeErrorMessage(TextManager.getText("wrong_path_to_extract"));
        }
    }
}
