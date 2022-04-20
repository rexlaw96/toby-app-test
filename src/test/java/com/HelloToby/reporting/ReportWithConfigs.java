package com.HelloToby.reporting;


import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReportWithConfigs {

//        @Test
        public void generateReport() {

        System.out.println("….generateReport");

        String outputPath = "target/report";

        List<String> jsonFiles = new ArrayList<String>();

        jsonFiles.add("target/report/cucumber.json");

        Configuration config = new Configuration(new File(outputPath), "Mini Report");

        config.setBuildNumber("001");

        config.addClassifications("Platform", "Android");
        config.addClassifications("API Level", "API-30");
        config.addClassifications("OS Version", "11.0");


        File embeddings = config.getEmbeddingDirectory();

        System.out.println("…embeddings file :" + embeddings.getPath());



        config.setSortingMethod(SortingMethod.NATURAL);

        config.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);

        config.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);

        config.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));

        config.setTrendsStatsFile(new File("target/report/trends.json"));

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, config);
        Reportable result = reportBuilder.generateReports();





    }

}

