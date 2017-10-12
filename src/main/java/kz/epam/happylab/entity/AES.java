package kz.epam.happylab.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class AES {
    private int id;
    private int probeId;
    private int numberLab;
    private Date date;
    private int employeeId;
    private double silver; //Ag;
    private double aluminium; //Al
    private double arsenic; //As
    private double boron; //B
    private double beryllium; //Be
    private double barium; //Ba
    private double bismuth; //Bi;
    private double calcium; //Ca
    private double cadmium; //Cd
    private double cobalt; //Co;
    private double chromium; //Cr;
    private double copper; //Cu;
    private double iron; //Fe
    private double potassium; //K
    private double lithium; //Li
    private double magnesium; //Mg
    private double manganese; //Mn
    private double molybdenum; //Mo
    private double sodium; //Na
    private double nickel; //Ni
    private double phosphorus; //P
    private double lead; //Pb
    private double sulphur; //S;
    private double antimony; //Sb
    private double selenium; //Se
    private double silicon; //Si
    private double tin; //Sn
    private double strontium; //Sr
    private double titanium; //Ti
    private double thallium; //Tl
    private double vanadium; //V
    private double tungsten; //W
    private double zinc; //Zn
    private List<Probe> probes;
    private List<Employee> employees;
    private Collection journal;

    public AES() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProbeId() {
        return probeId;
    }

    public void setProbeId(int probeId) {
        this.probeId = probeId;
    }

    public int getNumberLab() {
        return numberLab;
    }

    public void setNumberLab(int numberLab) {
        this.numberLab = numberLab;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getSilver() {
        return silver;
    }

    public void setSilver(double silver) {
        this.silver = silver;
    }

    public double getAluminium() {
        return aluminium;
    }

    public void setAluminium(double aluminium) {
        this.aluminium = aluminium;
    }

    public double getArsenic() {
        return arsenic;
    }

    public void setArsenic(double arsenic) {
        this.arsenic = arsenic;
    }

    public double getBoron() {
        return boron;
    }

    public void setBoron(double boron) {
        this.boron = boron;
    }

    public double getBeryllium() {
        return beryllium;
    }

    public void setBeryllium(double beryllium) {
        this.beryllium = beryllium;
    }

    public double getBarium() {
        return barium;
    }

    public void setBarium(double barium) {
        this.barium = barium;
    }

    public double getBismuth() {
        return bismuth;
    }

    public void setBismuth(double bismuth) {
        this.bismuth = bismuth;
    }

    public double getCalcium() {
        return calcium;
    }

    public void setCalcium(double calcium) {
        this.calcium = calcium;
    }

    public double getCadmium() {
        return cadmium;
    }

    public void setCadmium(double cadmium) {
        this.cadmium = cadmium;
    }

    public double getCobalt() {
        return cobalt;
    }

    public void setCobalt(double cobalt) {
        this.cobalt = cobalt;
    }

    public double getChromium() {
        return chromium;
    }

    public void setChromium(double chromium) {
        this.chromium = chromium;
    }

    public double getCopper() {
        return copper;
    }

    public void setCopper(double copper) {
        this.copper = copper;
    }

    public double getIron() {
        return iron;
    }

    public void setIron(double iron) {
        this.iron = iron;
    }

    public double getPotassium() {
        return potassium;
    }

    public void setPotassium(double potassium) {
        this.potassium = potassium;
    }

    public double getLithium() {
        return lithium;
    }

    public void setLithium(double lithium) {
        this.lithium = lithium;
    }

    public double getMagnesium() {
        return magnesium;
    }

    public void setMagnesium(double magnesium) {
        this.magnesium = magnesium;
    }

    public double getManganese() {
        return manganese;
    }

    public void setManganese(double manganese) {
        this.manganese = manganese;
    }

    public double getMolybdenum() {
        return molybdenum;
    }

    public void setMolybdenum(double molybdenum) {
        this.molybdenum = molybdenum;
    }

    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    public double getNickel() {
        return nickel;
    }

    public void setNickel(double nickel) {
        this.nickel = nickel;
    }

    public double getPhosphorus() {
        return phosphorus;
    }

    public void setPhosphorus(double phosphorus) {
        this.phosphorus = phosphorus;
    }

    public double getLead() {
        return lead;
    }

    public void setLead(double lead) {
        this.lead = lead;
    }

    public double getSulphur() {
        return sulphur;
    }

    public void setSulphur(double sulphur) {
        this.sulphur = sulphur;
    }

    public double getAntimony() {
        return antimony;
    }

    public void setAntimony(double antimony) {
        this.antimony = antimony;
    }

    public double getSelenium() {
        return selenium;
    }

    public void setSelenium(double selenium) {
        this.selenium = selenium;
    }

    public double getSilicon() {
        return silicon;
    }

    public void setSilicon(double silicon) {
        this.silicon = silicon;
    }

    public double getTin() {
        return tin;
    }

    public void setTin(double tin) {
        this.tin = tin;
    }

    public double getStrontium() {
        return strontium;
    }

    public void setStrontium(double strontium) {
        this.strontium = strontium;
    }

    public double getTitanium() {
        return titanium;
    }

    public void setTitanium(double titanium) {
        this.titanium = titanium;
    }

    public double getThallium() {
        return thallium;
    }

    public void setThallium(double thallium) {
        this.thallium = thallium;
    }

    public double getVanadium() {
        return vanadium;
    }

    public void setVanadium(double vanadium) {
        this.vanadium = vanadium;
    }

    public double getTungsten() {
        return tungsten;
    }

    public void setTungsten(double tungsten) {
        this.tungsten = tungsten;
    }

    public double getZinc() {
        return zinc;
    }

    public void setZinc(double zinc) {
        this.zinc = zinc;
    }

    public List<Probe> getProbes() {
        return probes;
    }

    public void setProbes(List<Probe> probes) {
        this.probes = probes;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Collection getJournal() {
        return journal;
    }

    public void setJournal(Collection journal) {
        this.journal = journal;
    }


}
