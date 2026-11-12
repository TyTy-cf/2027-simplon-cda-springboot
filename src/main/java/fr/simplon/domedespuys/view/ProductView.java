package fr.simplon.domedespuys.view;

public class ProductView {

    public interface Id {}
    public interface Label {}
    public interface Description {}
    public interface Price {}
    public interface Slug {}
    public interface CreatedAt {}
    public interface Brand {}
    public interface Images {}
    public interface MainImage {}

    public interface ProductListView extends
            Id,
            Label,
            Price,
            MainImage,
            ImageView.Path,
            Slug {}
    public interface ProductDetailView extends
            Id,
            Label,
            Price,
            Description,
            Slug,
            Brand,
            BrandView.Label,
            BrandView.Slug,
            Images,
            ImageView.Path,
            ImageView.Extension,
            ImageView.IsDefault {}

}
