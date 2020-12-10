package com.rosia.promotionservice.promotion.service.normal.type.multiple.family

import com.rosia.promotionservice.promotion.service.Promotion
import com.rosia.promotionservice.promotion.service.PromotionService
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

class MultiplePromotionCriteriaFamilyAmountServiceTest {
    @InjectMocks
    lateinit var promotion: Promotion

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun checkCriteriaAmount_AmountDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = NormalMultipleFamilyDataSource.get_amount_amount_promotion_success(),
        )
        Assert.assertEquals(true, promotion.promotionModel.isApplied)
    }

    @Test
    fun checkCriteriaAmount_AmountDisbursement_onError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = NormalMultipleFamilyDataSource.get_amount_amount_promotion_false(),
        )
        Assert.assertEquals(false, promotion.promotionModel.isApplied)
    }

    @Test
    fun checkCriteriaAmount_PercentDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = NormalMultipleFamilyDataSource.get_amount_percent_promotion_success(),
        )
        Assert.assertEquals(true, promotion.promotionModel.isApplied)
//        Assert.assertEquals(5.0, promotion.promotionModel.skuList.first().discountAmount, 0.0)
//        Assert.assertEquals(2.5, promotion.promotionModel.skuList.last().discountAmount, 0.0)
//        Assert.assertEquals("", promotion.message)
        println("${promotion.promotionModel.disbursementValue}")
    }

    @Test
    fun checkCriteriaAmount_PercentDisbursement_onError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = NormalMultipleFamilyDataSource.get_amount_percent_promotion_error(),
        )
        Assert.assertEquals(false, promotion.promotionModel.isApplied)
    }

    @Test
    fun checkCriteriaAmount_SkuDisbursement_shouldReturnTrue() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = NormalMultipleFamilyDataSource.get_amount_sku_promotion_success(),
        )
        Assert.assertEquals(true, promotion.promotionModel.isApplied)
        Assert.assertEquals(1.0, promotion.promotionModel.newDisbursementValue, 0.0)
        Assert.assertEquals("", promotion.message)
    }

    @Test
    fun checkNormalAmount_SkuDisbursement_onError() {
        val promotionService = PromotionService(
            listener = promotion
        )
        promotionService.checkPromotion(
            promotionModel = NormalMultipleFamilyDataSource.get_amount_sku_promotion_error(),
        )
        Assert.assertEquals(false, promotion.promotionModel.isApplied)
    }
}