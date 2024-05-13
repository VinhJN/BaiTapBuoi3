package com.vinhbqph33437.baitapbuoi3

import java.util.Scanner

open class Nguoi(
    var hoTen: String,
    var tuoi: Int,
    var queQuan: String,
    var maSo: String
)

class CBGV(
    hoTen: String,
    tuoi: Int,
    queQuan: String,
    maSo: String,
    var luongCung: Double,
    var luongThuong: Double,
    var tienPhat: Double
) : Nguoi(hoTen, tuoi, queQuan, maSo) {
    fun tinhLuongThucLinh(): Double {
        return luongCung + luongThuong - tienPhat
    }
}

class KhoaCNTT {
    private val danhSachCBGV = mutableListOf<CBGV>()

    fun themCBGV(cbgv: CBGV) {
        danhSachCBGV.add(cbgv)
    }

    fun xoaCBGV(maSo: String) {
        danhSachCBGV.removeIf { it.maSo == maSo }
    }

    fun hienThiDanhSach() {
        danhSachCBGV.forEachIndexed { index, cbgv ->
            println("Cán bộ giáo viên ${index + 1}: ${cbgv.hoTen}, Lương thực lĩnh: ${cbgv.tinhLuongThucLinh()}")
        }
    }
}

fun main() {
    val khoaCNTT = KhoaCNTT()
    val scanner = Scanner(System.`in`)

    // Menu
    println("Chọn chức năng:")
    println("1. Thêm cán bộ giáo viên")
    println("2. Xóa cán bộ giáo viên")
    println("3. Hiển thị danh sách cán bộ giáo viên")
    println("4. Thoát")

    while (true) {
        print("Nhập lựa chọn của bạn: ")
        val luaChon = scanner.nextInt()
        scanner.nextLine() // Đọc newline character

        when (luaChon) {
            1 -> {
                println("Nhập thông tin cán bộ giáo viên:")
                print("Họ tên: ")
                val hoTen = scanner.nextLine()
                print("Tuổi: ")
                val tuoi = scanner.nextInt()
                scanner.nextLine() // Đọc newline character
                print("Quê quán: ")
                val queQuan = scanner.nextLine()
                print("Mã số: ")
                val maSo = scanner.nextLine()
                print("Lương cứng: ")
                val luongCung = scanner.nextDouble()
                print("Lương thưởng: ")
                val luongThuong = scanner.nextDouble()
                print("Tiền phạt: ")
                val tienPhat = scanner.nextDouble()

                val cbgv = CBGV(hoTen, tuoi, queQuan, maSo, luongCung, luongThuong, tienPhat)
                khoaCNTT.themCBGV(cbgv)
            }
            2 -> {
                print("Nhập mã số cán bộ giáo viên cần xóa: ")
                val maSo = scanner.nextLine()
                khoaCNTT.xoaCBGV(maSo)
            }
            3 -> {
                println("Danh sách cán bộ giáo viên:")
                khoaCNTT.hienThiDanhSach()
            }
            4 -> {
                println("Kết thúc chương trình.")
                return
            }
            else -> println("Lựa chọn không hợp lệ.")
        }
    }
}
