package com.lab01.misc;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BRCMain {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        List<WeatherData> dataList = fillData();
        Map<String, List<WeatherData>> dataMap = dataList.parallelStream().collect(Collectors.groupingBy(WeatherData::getStation));
        List<Output> outputs = new ArrayList<>();
        dataMap.forEach((key, value) -> {
            Optional<Double> minO = value.parallelStream().map(WeatherData::getTemp).reduce(Double::min);
            Optional<Double> maxO = value.parallelStream().map(WeatherData::getTemp).reduce(Double::max);
            Optional<Double> totalO = value.parallelStream().map(WeatherData::getTemp).reduce(Double::sum);
            Double min = minO.orElse(0.0);
            Double max = maxO.orElse(0.0);
            Double mean = totalO.orElse(0.0) / value.size();
            outputs.add(new Output(key, min, max, mean));
        });
        outputs.sort(Comparator.comparing(Output::getStation));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        outputs.forEach(s -> stringBuilder.append(s.toString()));
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append("}");
        //System.out.printf("output %s \n", stringBuilder);
        System.out.printf("Total lines %s \n", dataList.size());
        System.out.printf("processed in  %s ms \n", (System.currentTimeMillis() - startTime));
    }

    private static List<WeatherData> fillData() throws FileNotFoundException {
        List<WeatherData> dataList = new ArrayList<>();
        File file = new File("weather_stations.csv");
        Scanner scanner = new Scanner(new FileInputStream(file));
        //skipping first two lines
        scanner.nextLine();
        scanner.nextLine();
        while (scanner.hasNext()){
            String[] data = scanner.nextLine().trim().split(";");
            if(data.length == 2)
                dataList.add(new WeatherData(data[0], Double.parseDouble(data[1])));
        }
        return dataList;
    }


}

class WeatherData{
    private String station;
    private Double temp;

    public String getStation() {
        return station;
    }

    public Double getTemp() {
        return temp;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public WeatherData(String station, Double temp) {
        this.station = station;
        this.temp = temp;
    }
}

class Output{
    public Output(String station, Double min, Double max, Double mean) {
        this.station = station;
        this.min = min;
        this.max = max;
        this.mean = mean;
    }

    private String station;
    private Double min;
    private Double max;
    private Double mean;

    public String getStation() {
        return station;
    }
    public void setStation(String station) {
        this.station = station;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Double getMean() {
        return mean;
    }

    public void setMean(Double mean) {
        this.mean = mean;
    }

    @Override
    public String toString() {
        return String.format("%s=%s/%s/%s, ",station, min, mean, max);
    }
}