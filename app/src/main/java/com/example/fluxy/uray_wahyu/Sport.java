package com.example.fluxy.uray_wahyu;

class Sport {

    // Member variables representing the title and information about the sport.
    private String title;
    private String info;
    private final int imageResource;
    private final int i;

    /**
     * Constructor for the Sport data model.
     *
     * @param title The name if the sport.
     * @param info Information about the sport.
     */
    public Sport(String title, String info, int imageResource, int i) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
        this.i= i;
    }

    /**
     * Gets the title of the sport.
     *
     * @return The title of the sport.
     */
    String getTitle() {
        return title;
    }

    /**
     * Gets the info about the sport.
     *
     * @return The info about the sport.
     */
    String getInfo() {
        return info;
    }

    public int getImageResource() {
        return imageResource;
    }
    public int getPos() { return i; }

}