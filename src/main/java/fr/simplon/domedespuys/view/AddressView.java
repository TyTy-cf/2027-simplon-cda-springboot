package fr.simplon.domedespuys.view;

public class AddressView {
    public interface Id {}
    public interface City {}
    public interface ZipCode {}
    public interface Country {}
    public interface Line {}
    public interface ExtraLine {}
    public interface FirstName {}
    public interface LastName {}
    public interface Phone {}

    public interface AddressDetailView extends
            Id,
            City,
            ZipCode,
            Line,
            FirstName,
            LastName,
            Phone,
            Country,
            ExtraLine {}

}
