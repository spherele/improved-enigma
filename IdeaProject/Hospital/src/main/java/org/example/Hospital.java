package org.example;

public class Hospital {
    private static final double MIN_TEMPERATURE = 32.0;
    private static final double MAX_TEMPERATURE = 40.0;
    public static double[] generatePatientsTemperatures(int patientsCount){
        double[] patientsTemperatures = new double[patientsCount];
        for (int i = 0; i < patientsCount; i++){
            patientsTemperatures[i] = Math.random() * ((MAX_TEMPERATURE - MIN_TEMPERATURE)) + MIN_TEMPERATURE;
        }
        return patientsTemperatures;
    }
    public static String getReport(double[] patientsTemperatures){
        StringBuilder report = new StringBuilder("Темепературы пациентов: ");

        for (int i = 0; i < patientsTemperatures.length; i++){
            report.append(String.format("%.2f", patientsTemperatures[i]).replace(',', '.')).append(", ");
        }
        report.setLength(report.length() - 2);

        double averageTemperature = 0;
        for (int i = 0; i < patientsTemperatures.length; i++){
            averageTemperature += patientsTemperatures[i];
        }
        averageTemperature /= patientsTemperatures.length;
        report.append("\nСредняя температура: ").append(String.format("%.1f", averageTemperature).replace(',', '.'));

        int healthyPatientsCount = 0;
        for (int i = 0; i < patientsTemperatures.length; i++){
            if (patientsTemperatures[i] >= 36.2 && patientsTemperatures[i] <= 36.9) healthyPatientsCount++;
        }
        report.append("\nВыздоровевших пациентов: ").append(healthyPatientsCount);

        return report.toString();
    }

}
