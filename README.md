
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
    - `ICreate` (`ImageDTO`  : path, isDefault) -> utilisé depuis le `IProductService`
    - `IDelete`

- `IProductService` implémente les interfaces suivantes :
    - `ICreate` (ProductPostDTO : label, description, price, brand, images [List<ImageDTO>]) -> set createdAt
    - `IUpdate` (ProductPutDTO : label, description, price, brand, images [List<ImageDTO>])
    - `IGetItem`
    - `ICollection`

- `IPurchaseService` implémente les interfaces suivantes :
    - `ICreate` (PurchasePostDTO : addressId [Long], purchaseProducts [List<PurchaseProductDTO>]) -> set createdAt, status [PENDING], user (prendre un user lambda, pour le moment), number [généré : PUR-ANNEE-0000ID_USER] + création des PurchaseProduct
    - `IUpdate` (PurchasePutDTO : status)
    - `IGetItem`
    - `ICollection`

- `PurchaseProductServiceImpl` implémente les interfaces suivantes :
    - `IPurchaseProductService` : renvoie un objet `PurchaseProduct` ; prend en paramètre un `PurchaseProductDTO`et un `Purchase`

- `PurchaseProductDTO`
  - int qty
  - int price
  - Long idProduct


## 2. Implémenter correctement les services


### 2.1. Rendre l'existant fonctionnel (again) 


- Faire l'implémentation des méthodes GET (item & collection) dans les contrôleurs précédemment créés
- Réutiliser ces méthodes dans les contrôleurs adéquats :
  - Product : GET item; GET collection
  - User : GET item
  - Purchase : GET item; GET collection


### 2.2. Compléter...


- Implémenter les méthodes POST, PUT et DELETE pour les contrôleurs où cela est nécessaire, avec leur implémentation dans le service adéquat
- Il faudra créé les contrôleurs suivants :
  - Address
  - Image
    (Ne pas faire de PurchaseProductController !!!!)