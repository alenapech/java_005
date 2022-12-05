package com.alenapech;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

// Дана строка. Необходимо написать метод, который отсортирует слова в строке по длине с помощью TreeMap.
//    Пример:
//    Входные данные:
//    Если вы можете мечтать об этом вы можете это сделать
//    Выходные данные:
//    вы об вы это если этом можете можете мечтать сделать
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Input string:");
        List<String> inputList = Arrays.stream(input.nextLine().split(" ")).collect(Collectors.toList());
        Map<String, Integer> inputMap = new TreeMap<>();
        Map<String, Integer> repMap = new HashMap<>();
        inputList.forEach(value -> {
            if(repMap.containsKey(value))
                repMap.put(value, repMap.get(value) + 1);
            else
                repMap.put(value, 1);
            inputMap.put(value, value.length());
        });
        System.out.println("Output string: ");
        System.out.println(getSortedIncludesWords(inputMap, repMap));
    }

    public static String getSortedIncludesWords(final Map<String, Integer> map, final Map<String, Integer> repMap){
        List<String> resultList = map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        StringBuilder result = new StringBuilder();
        for (String r : resultList) {
            for (int i=0; i < repMap.get(r); i++) {
                result.append(r).append(" ");
            }
        }
        return result.toString();
    }

}
