
# API + Service

## 1. Création des Interfaces restantes

Pour le moment vous devez seulement créer les interfaces et les DTO suivants, aucun contrôleur ni corps de méthodes n'est demandé. 

- `IUserService` implémente les interfaces suivantes : 
  - `ICreate` (UserPostDTO : email, password, firstName, lastName) -> set createdAt
  - `IUpdate` (UserPutDTO : firstname, lastname, phone)
  - `IDelete` -> MAIS pas un vrai delete physique : on va anonymiser les champs de l'utilisateur
  - `IGetItem`

- `IAddressService` implémente les interfaces suivantes :
    - `ICreate` (AddressDTO : line, extraLine, zipCode, city, country, phone, firstName, lastName) -> set createdAt + user (prendre un user lambda, pour le moment)
    - `IUpdate` (AddressDTO : line, extraLine, zipCode, city, country, phone, firstName, lastName)
    - `IDelete`

- `IImageService` implémente les interfaces suivantes :
    - `IDelete`

- `IProductService` implémente les interfaces suivantes :
    - `ICreate` (ProductPostDTO : label, description, price, brand, images [List<String>]) -> set createdAt
    - `IUpdate` (ProductPutDTO : label, description, price, brand, images [List<String>])
    - `IGetItem`
    - `ICollection`

- `IPurchaseService` implémente les interfaces suivantes :
    - `ICreate` (PurchasePostDTO : address [AddressDTO], purchaseProducts [List<PurchaseProductDTO>]) -> set createdAt, status [PENDING], user (prendre un user lambda, pour le moment), number [généré : PUR-ANNEE-0000ID_USER] + création des PurchaseProduct
    - `IUpdate` (PurchasePutDTO : status)
    - `IGetItem`
    - `ICollection`

- `IPurchaseProductService` implémente les interfaces suivantes :
    - `ICreatePurchaseProduct` : renvoie un objet `PurchaseProduct` ; prend en paramètre un `PurchaseProductDTO`et un `Purchase`

- `PurchaseProductDTO`
  - int qty
  - int price
  - Long idProduct