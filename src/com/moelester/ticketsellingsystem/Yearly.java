package com.moelester.ticketsellingsystem;

public class Yearly implements Ticket {

    /**
     * <pre>
     * Indicates the type of ticket:
     * ONLY USE "Yearly" or "Daily"
     * Failure to do so results in exceptions in determinePrice()
     * <pre>
     */
    private String type = null;
    /**
     * <pre>
     * Indicates the category of ticket:
     * ONLY USE "Senior", "Adult" or "Kid/Student"
     * Failure to do so results in exceptions in determinePrice()
     * <pre>
     */
    private String category = null;
    /**
     * <pre>
     * Indicates the price of ticket:
     * It is automatically determined with determinePrice()
     * <pre>
     */
    private double price = 0;

    /**
     * Constructor for ticket subtypes
     *
     * @param c "Senior", "Adult" or "Kid/Student"
     */

    private String idNum;
    private String name;
    private String addr;
    private String gender;

    public Yearly(String c) {
        //TODO implement try catch / if else for input validation
        this.type = "Yearly";
        this.category = c;
        determinePrice(type, category);
    }

    // Override getters and setters from Ticket interface
    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setPrice(double p) {
        price = p;
    }

    @Override
    public void setCategory(String c) {
        category = c;
    }

    @Override
    public void setType(String t) {
        type = t;
    }

    // Override abstract methods from Ticket interface
    @Override
    public int reportAmt() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double reportProfit() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Getters and setters implementation
    public String getIdNum() {
        return idNum;
    }

    public String getName() {
        return name;
    }

    public String getAddr() {
        return addr;
    }

    public String getGender() {
        return gender;
    }

    public void setIdNum(String idNum) {

        if (idNum.matches("[0-9]+")) {
            this.idNum = idNum;
        } else {
            System.out.print("Invalid input. Please input numbers only.");
            this.idNum = null;
        }
    }

    public void setName(String name) {

        if (name.matches("[a-zA-Z]+")) {
            this.name = name;
        } else {
            System.out.print("Invalid input. Please enter again.");
            this.name = null;
        }
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setGender(String gender) {

        if (gender == "m" || gender == "M" || gender == "f" || gender == "F") {
            this.gender = gender;
        } else {
            System.out.print("Invalid input. Please enter 'F' or 'M' only.");
            this.gender = null;
        }
    }

    // Switch case for price table
    private void determinePrice(String t, String c) {
        switch (t) {
            case "Daily":
                switch (c) {
                    case "Senior":
                        setPrice(PRICE_LIST[0][0]);
                        break;
                    case "Adult":
                        setPrice(PRICE_LIST[1][0]);
                        break;
                    case "Kid/Student":
                        setPrice(PRICE_LIST[2][0]);
                        break;
                    default:
                        System.out.println("Invalid category entered.");
                }
                break;

            case "Yearly":
                switch (c) {
                    case "Senior":
                        setPrice(PRICE_LIST[0][1]);
                        break;
                    case "Adult":
                        setPrice(PRICE_LIST[1][1]);
                        break;
                    case "Kid/Student":
                        setPrice(PRICE_LIST[2][1]);
                        break;
                    default:
                        System.out.println("Invalid category entered.");
                }
                break;

            default:
                System.out.println("Invalid type entered.");
                break;
        }
    }

}
