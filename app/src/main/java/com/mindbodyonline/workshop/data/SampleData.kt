package com.mindbodyonline.workshop.data

import com.example.androiddevchallenge.R
import com.mindbodyonline.workshop.data.model.*
import java.util.*

class SampleData {


    object Services {
        val therapeuticMassage = Service(
            ServiceId("therapeutic-massage"),
            Categories.massage.id,
            "Therapeutic Massage",
            R.drawable.image_therapeutic_massage,
            listOf(
                PriceOption(60, Currency.getInstance("USD"), 30),
                PriceOption(90, Currency.getInstance("USD"), 60),
                PriceOption(110, Currency.getInstance("USD"), 90)
            )
        )

        val relaxationMassage = Service(
            ServiceId("relaxation-massage"),
            Categories.massage.id,
            "Relaxation Massage",
            R.drawable.image_relaxing_massage,
            listOf(
                PriceOption(50, Currency.getInstance("USD"), 30),
                PriceOption(70, Currency.getInstance("USD"), 60),
                PriceOption(100, Currency.getInstance("USD"), 90)
            )
        )
        val hotStoneMassage = Service(
            ServiceId("hot-stone-massage"),
            Categories.massage.id,
            "Hot Stone Massage",
            R.drawable.image_hot_stone_massage,
            listOf(
                PriceOption(50, Currency.getInstance("USD"), 30),
                PriceOption(70, Currency.getInstance("USD"), 60),
                PriceOption(100, Currency.getInstance("USD"), 90)
            )
        )

        val browWax = Service(
            ServiceId("eyebrow-wax"),
            Categories.wax.id,
            "Eyebrow Wax",
            R.drawable.image_eyebrow_wax,
            listOf(
                PriceOption(15, Currency.getInstance("USD"), 15)
            )
        )
        val legWax = Service(
            ServiceId("leg-wax"),
            Categories.wax.id,
            "Leg Wax",
            R.drawable.image_leg_wax,
            listOf(
                PriceOption(80, Currency.getInstance("USD"), 45)
            )
        )
        val beardTrim = Service(
            ServiceId("beard-trim"),
            Categories.hairStyle.id,
            "Beard Trim",
            R.drawable.image_beard_trim,
            listOf(
                PriceOption(20, Currency.getInstance("USD"), 15),
            )
        )
        val hairCut = Service(
            ServiceId("hair-cut"),
            Categories.hairStyle.id,
            "Hair Cut",
            R.drawable.image_hair_cut,
            listOf(
                PriceOption(60, Currency.getInstance("USD"), 60),
            )
        )
        val balayage = Service(
            ServiceId("balayage"),
            Categories.hairStyle.id,
            "Balayage",
            R.drawable.image_balayage,
            listOf(
                PriceOption(130, Currency.getInstance("USD"), 120),
            )
        )

        val massageServices = listOf(therapeuticMassage, relaxationMassage, hotStoneMassage)
        val waxServices = listOf(browWax, legWax)
        val hairServices = listOf(hairCut, balayage, beardTrim)

        val allServices = massageServices.plus(waxServices).plus(hairServices).shuffled()
    }

    object Categories {
        val massage = ServiceCategory(
            ServiceCategoryId("massage"),
            "Massage"
        )
        val wax = ServiceCategory(
            ServiceCategoryId("wax"),
            "Waxing"
        )
        val hairStyle = ServiceCategory(
            ServiceCategoryId("hairstyle"),
            "Hair Styling"
        )
        val allCategories = listOf(massage, wax, hairStyle)
    }

    object StaffMembers {
        val staff1 = Staff(
            StaffId("1"),
            "Ijeoma M.",
            R.drawable.avatar_ijeoma,
            listOf(Categories.massage.id)
        )
        val staff2 = Staff(
            StaffId("2"),
            "Martín E.",
            R.drawable.avatar_martin,
            listOf(Categories.massage.id, Categories.wax.id)
        )
        val staff3 = Staff(
            StaffId("3"),
            "Karli M.",
            R.drawable.avatar_karli,
            listOf(Categories.hairStyle.id, Categories.wax.id)
        )
        val staff4 = Staff(
            StaffId("4"),
            "Ken Y.",
            R.drawable.avatar_ken,
            listOf(Categories.hairStyle.id, Categories.massage.id, Categories.wax.id)
        )
        val staff5 = Staff(
            StaffId("5"),
            "Efeturi G.",
            R.drawable.avatar_efeturi,
            listOf(Categories.hairStyle.id, Categories.wax.id)
        )
        val staff6 = Staff(
            StaffId("6"),
            "Sarah W.",
            R.drawable.avatar_sarah,
            listOf(Categories.hairStyle.id, Categories.massage.id, Categories.wax.id)
        )
        val staff7 = Staff(
            StaffId("7"),
            "Marisol R.",
            R.drawable.avatar_marisol,
            listOf(Categories.hairStyle.id, Categories.massage.id, Categories.wax.id)
        )

        val allStaff = listOf(staff1, staff2, staff3, staff4, staff5, staff6, staff7)
    }

}