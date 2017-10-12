package kz.epam.happylab.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class PSA {
    private int id;
    private int probeId;
    private int numberLab;
    private Date date;
    private int employeeId;
    private double silver; //Ag;
    private double aluminium; //Al
    private double arsenic; //As
    private double gold; //Au
    private double boron; //B
    private double barium; //Ba
    private double beryllium; //Be
    private double bismuth; //Bi;
    private double cadmium; //Cd
    private double cerium; //Ce
    private double cobalt; //Co;
    private double chromium; //Cr;
    private double copper; //Cu;
    private double iron; //Fe
    private double gallium; //Ga
    private double germanium; //Ge
    private double hafnium; //Hf
    private double indium; //In
    private double lanthanum; //La
    private double lithium; //Li
    private double manganese; //Mn
    private double molybdenum; //Mo
    private double niobium; //Nb
    private double nickel; //Ni
    private double phosphorus; //P
    private double lead; //Pb
    private double platinum; //Pt
    private double antimony; //Sb
    private double scandium; //Sc
    private double tin; //Sn
    private double strontium; //Sr
    private double tantalum; //Ta
    private double tellurium; //Te
    private double thorium; //Th
    private double titanium; //Ti
    private double thallium; //Tl
    private double uranium; //U
    private double vanadium; //V
    private double tungsten; //W
    private double yttrium; //Y
    private double ytterbium; //Yb
    private double zinc; //Zn
    private double zirconium; //Zr
    private List<Probe> probes;
    private List<Employee> employees;
    private Collection journal;

    public PSA() {
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

    public double getGold() {
        return gold;
    }

    public void setGold(double gold) {
        this.gold = gold;
    }

    public double getBoron() {
        return boron;
    }

    public void setBoron(double boron) {
        this.boron = boron;
    }

    public double getBarium() {
        return barium;
    }

    public void setBarium(double barium) {
        this.barium = barium;
    }

    public double getBeryllium() {
        return beryllium;
    }

    public void setBeryllium(double beryllium) {
        this.beryllium = beryllium;
    }

    public double getBismuth() {
        return bismuth;
    }

    public void setBismuth(double bismuth) {
        this.bismuth = bismuth;
    }

    public double getCadmium() {
        return cadmium;
    }

    public void setCadmium(double cadmium) {
        this.cadmium = cadmium;
    }

    public double getCerium() {
        return cerium;
    }

    public void setCerium(double cerium) {
        this.cerium = cerium;
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

    public double getGallium() {
        return gallium;
    }

    public void setGallium(double gallium) {
        this.gallium = gallium;
    }

    public double getGermanium() {
        return germanium;
    }

    public void setGermanium(double germanium) {
        this.germanium = germanium;
    }

    public double getHafnium() {
        return hafnium;
    }

    public void setHafnium(double hafnium) {
        this.hafnium = hafnium;
    }

    public double getIndium() {
        return indium;
    }

    public void setIndium(double indium) {
        this.indium = indium;
    }

    public double getLanthanum() {
        return lanthanum;
    }

    public void setLanthanum(double lanthanum) {
        this.lanthanum = lanthanum;
    }

    public double getLithium() {
        return lithium;
    }

    public void setLithium(double lithium) {
        this.lithium = lithium;
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

    public double getNiobium() {
        return niobium;
    }

    public void setNiobium(double niobium) {
        this.niobium = niobium;
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

    public double getPlatinum() {
        return platinum;
    }

    public void setPlatinum(double platinum) {
        this.platinum = platinum;
    }

    public double getAntimony() {
        return antimony;
    }

    public void setAntimony(double antimony) {
        this.antimony = antimony;
    }

    public double getScandium() {
        return scandium;
    }

    public void setScandium(double scandium) {
        this.scandium = scandium;
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

    public double getTantalum() {
        return tantalum;
    }

    public void setTantalum(double tantalum) {
        this.tantalum = tantalum;
    }

    public double getTellurium() {
        return tellurium;
    }

    public void setTellurium(double tellurium) {
        this.tellurium = tellurium;
    }

    public double getThorium() {
        return thorium;
    }

    public void setThorium(double thorium) {
        this.thorium = thorium;
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

    public double getUranium() {
        return uranium;
    }

    public void setUranium(double uranium) {
        this.uranium = uranium;
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

    public double getYttrium() {
        return yttrium;
    }

    public void setYttrium(double yttrium) {
        this.yttrium = yttrium;
    }

    public double getYtterbium() {
        return ytterbium;
    }

    public void setYtterbium(double ytterbium) {
        this.ytterbium = ytterbium;
    }

    public double getZinc() {
        return zinc;
    }

    public void setZinc(double zinc) {
        this.zinc = zinc;
    }

    public double getZirconium() {
        return zirconium;
    }

    public void setZirconium(double zirconium) {
        this.zirconium = zirconium;
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
