package com.rosia.promotionservice.promotion.service.normal.criteria

import com.rosia.promotionservice.promotion.data.PromotionModel

interface CriteriaReceiver {
    fun handleAmountCriteriaUseCase(promotion: PromotionModel): Boolean
    fun handleQuantityCriteriaUseCase(promotion: PromotionModel): Boolean
    fun handleCountCriteriaUseCase(promotion: PromotionModel): Boolean
}