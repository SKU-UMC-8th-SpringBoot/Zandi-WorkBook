package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Store;
import umc.spring.repository.StoreRepository.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store>findStoresByNameAndScore(String name, Float score) {
        List<Store> filterdStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);

        filterdStores.forEach(store -> System.out.println("Store : " + store));
        return filterdStores;
    }

}
