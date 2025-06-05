package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public boolean existStore(Long id) {
        return storeRepository.existsById(id);
    }

    @Override
    public List<Store>findStoresByNameAndScore(String name, Float score) {
        List<Store> filterdStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);

        filterdStores.forEach(store -> System.out.println("Store : " + store));
        return filterdStores;
    }

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).get();

        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }

    @Override
    public Page<Mission> getMissionList(Long StoreId, int pageIndex) {
        Store store = storeRepository.findById(StoreId).get();
        Page<Mission> StoreMissionPage = missionRepository.findAllByStore(store, PageRequest.of(pageIndex, 10));
        return StoreMissionPage;
    }


}
