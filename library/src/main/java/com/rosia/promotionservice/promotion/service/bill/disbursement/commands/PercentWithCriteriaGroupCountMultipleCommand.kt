package com.rosia.promotionservice.promotion.service.bill.disbursement.commands

import com.rosia.promotionservice.promotion.data.PromotionModel
import com.rosia.promotionservice.promotion.service.Command
import com.rosia.promotionservice.promotion.service.bill.disbursement.DisbursementReceiver

class PercentWithCriteriaGroupCountMultipleCommand(
    private val disbursementReceiver: DisbursementReceiver,
    private val promotion: PromotionModel
) : Command {

    override fun execute(): Boolean {
        disbursementReceiver.handleBillPercentWithCriteriaGroupCountMultipleAmount(promotion)
        return false
    }
}