package learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ExamLearnings {

    public static final int HOUR_IN_MINUTES = 60;

    private Map<String, Integer> learnings = new HashMap<>();

    public void readFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                parseLine(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file.", ioe);
        }
    }

    private void parseLine(String line) {
        String[] parts = line.split(";");
        String[] times = Arrays.copyOfRange(parts, 1, parts.length);
        learnings.put(parts[0], getLearningTimeInMinutes(times));
    }

    private Integer getLearningTimeInMinutes(String[] times) {
        int timeInMinutes = 0;
        for (String actual : times) {
            String timeString = actual.replace(',', '.');
            double time = Double.parseDouble(timeString);
            timeInMinutes += time * HOUR_IN_MINUTES;
        }
        return timeInMinutes;
    }

    public double getAverageLearningInMinutes() {
        return learnings.values().stream()
                .mapToInt(i -> i)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("There are no learning times."));
    }

    public Map<String, Integer> getLearnings() {
        return new HashMap<>(learnings);
    }
}
