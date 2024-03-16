package com.nxm.palceup.service.impl;

import com.nxm.palceup.entities.ChangeProductDetail;
import com.nxm.palceup.entities.ProductChange;
import com.nxm.palceup.repositories.ChangeProductDetailRepository;
import com.nxm.palceup.service.ChangeProductDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChangeProductDetailServiceImpl implements ChangeProductDetailService {
    private final ChangeProductDetailRepository changeProductDetailRepository;

    @Override
    public void createChangeDetails(Integer id) {
        changeProductDetailRepository.createChangeDetails(id);
    }

    @Override
    public ChangeProductDetail findPrChangeDetails(ProductChange idPrChange) {
        return changeProductDetailRepository.findPrChangeDetails(idPrChange);
    }

    @Override
    public ChangeProductDetail save(ChangeProductDetail entity) {
        return changeProductDetailRepository.save(entity);
    }

    @Override
    public List<ChangeProductDetail> save(List<ChangeProductDetail> entities) {
        return changeProductDetailRepository.saveAll(entities);
    }

    @Override
    public void deleteById(Integer id) {
changeProductDetailRepository.deleteById(id);
    }

    @Override
    public Optional<ChangeProductDetail> findById(Integer id) {
        return changeProductDetailRepository.findById(id);
    }

    @Override
    public List<ChangeProductDetail> findAll() {
        return changeProductDetailRepository.findAll();
    }

    @Override
    public Page<ChangeProductDetail> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public ChangeProductDetail update(ChangeProductDetail entity, Integer id) {
        Optional<ChangeProductDetail> optional = findById(id) ;
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}
