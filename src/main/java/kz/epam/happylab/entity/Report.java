package kz.epam.happylab.entity;

import java.util.Collection;
import java.util.List;

public class Report {
    private String analysis;
    private String headLaboratory;
    private int filter_probe;
    private Collection result;
    private Collection results;
    private List<Probe> probes;
    private Probe probe;

    public Report() {
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getHeadLaboratory() {
        return headLaboratory;
    }

    public void setHeadLaboratory(String headLaboratory) {
        this.headLaboratory = headLaboratory;
    }

    public int getFilter_probe() {
        return filter_probe;
    }

    public void setFilter_probe(int filter_probe) {
        this.filter_probe = filter_probe;
    }

    public Collection getResult() {
        return result;
    }

    public void setResult(Collection result) {
        this.result = result;
    }

    public Collection getResults() {
        return results;
    }

    public void setResults(Collection results) {
        this.results = results;
    }

    public List<Probe> getProbes() {
        return probes;
    }

    public void setProbes(List<Probe> probes) {
        this.probes = probes;
    }

    public Probe getProbe() {
        return probe;
    }

    public void setProbe(Probe probe) {
        this.probe = probe;
    }
}
