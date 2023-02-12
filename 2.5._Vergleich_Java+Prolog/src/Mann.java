public class Mann {
    private final String name;
    private String vater = null;
    private String mutter = null;

    public Mann(String pName){
        name = pName;
    }
    public Mann(String pName, String pVater, String pMutter){
        name = pName;
        vater = pVater;
        mutter = pMutter;
    }
    //GETTER&SETTER
    public String getVater() {
        if (vater != null) return vater;
        return null;
    }
    public String getMutter() {
        if (mutter != null) return mutter;
        return null;
    }
    public String getName() {
        return name;
    }
}