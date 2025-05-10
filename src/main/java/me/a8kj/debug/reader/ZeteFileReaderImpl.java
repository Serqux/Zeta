package me.a8kj.debug.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ZeteFileReaderImpl implements ZetaFileReader {

    private final InputStream inputStream;

    @Override
    public boolean isValid() {
        return inputStream != null;
    }

    @Override
    public String read() {
        if (!isValid()) {
            throw new IllegalStateException("Input stream for .zeta file is invalid or null.");
        }

        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading .zeta input stream", e);
        }

        return content.toString();
    }
}
