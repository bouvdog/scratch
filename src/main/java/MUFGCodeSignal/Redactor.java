package MUFGCodeSignal;

import java.util.*;
import java.util.stream.Collectors;

public class Redactor {
    public static String censorFromBlacklistAndReplace(String sample_text, String[] blacklist, String replacement) {
        for (int i = 0; i < blacklist.length; i++) {
            sample_text = sample_text.replaceAll(blacklist[i], replacement);
        }
        return sample_text;
    }

    public static String arrangeApplicants(String[] ids, int[] scores) {
        Map<Integer, String> sortedApplicants = new TreeMap<>();
        Set<String> id = new HashSet<>();

        for (int i = 0; i < ids.length; i++) {
                id.add(ids[i]);
                sortedApplicants.put(scores[i], ids[i]);
        }

        Map <Integer, String> filteredMap = sortedApplicants.entrySet()
                .stream()
                .filter(entry -> id.add(entry.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        StringBuilder sb = new StringBuilder();
        for (Integer k : sortedApplicants.keySet()) {
            sb.append(sortedApplicants.get(k));
        }
        return sb.toString();
    }
}
