package fr.simplon.domedespuys.service.interfaces;

import fr.simplon.domedespuys.dto.PurchasePostDTO;
import fr.simplon.domedespuys.dto.PurchasePutDTO;
import fr.simplon.domedespuys.entity.Purchase;
import fr.simplon.domedespuys.service.interfaces.dao.ICreate;
import fr.simplon.domedespuys.service.interfaces.dao.IDelete;
import fr.simplon.domedespuys.service.interfaces.dao.IGetItem;
import fr.simplon.domedespuys.service.interfaces.dao.IUpdate;

public interface IPurchaseService extends
        ICreate<Purchase, PurchasePostDTO>,
        IUpdate<Purchase, PurchasePutDTO>,
        IGetItem<Purchase>,
        IDelete
{
}
