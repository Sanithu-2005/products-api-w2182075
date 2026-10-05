package uk.ac.westminster.products_api;
public class Customer {
    private Long id;
    private String name;
    private String email;
    private Address address;
    public static int customerCount = 0;
    private String[] tags;

    public Customer() {
        customerCount++; // Increment count
    }
    public Customer(Long id, String name, String email, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        customerCount++; // Increment count
    }

    public Customer(Long id, String name, String email, Address address, String[] tags) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.tags = tags;
        customerCount++;
    }

    // Getter for tags
    public String[] getTags() {
        return tags;
    }

    // Setter for tags
    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public Address getAddress() { return address; }}


