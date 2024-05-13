package com.vinhbqph33437.baitapbuoi3

import java.util.*
import java.util.Scanner


// Lớp SinhVien để quản lý thông tin của mỗi sinh viên
data class SinhVien(
    var hoTen: String,
    var tuoi: Int,
    var lop: String
)

// Lớp TheMuon để quản lý việc mượn trả sách của các sinh viên
data class TheMuon(
    var maPhieuMuon: String,
    var ngayMuon: Int,
    var hanTra: Int,
    var soHieuSach: String,
    var sinhVien: SinhVien
)

// Lớp QuanLyTheMuon để quản lý việc thêm, xoá thẻ mượn và hiển thị thông tin các thẻ mượn
class QuanLyTheMuon {
    private val danhSachTheMuon = mutableListOf<TheMuon>()

    fun themTheMuon(theMuon: TheMuon) {
        danhSachTheMuon.add(theMuon)
    }

    fun xoaTheMuon(maPhieuMuon: String) {
        danhSachTheMuon.removeIf { it.maPhieuMuon == maPhieuMuon }
    }

    fun hienThiDanhSach() {
        println("Danh sách các thẻ mượn sách:")
        danhSachTheMuon.forEachIndexed { index, theMuon ->
            println("Thẻ mượn số ${index + 1}:")
            println("Mã phiếu mượn: ${theMuon.maPhieuMuon}")
            println("Ngày mượn: ${theMuon.ngayMuon}")
            println("Hạn trả: ${theMuon.hanTra}")
            println("Số hiệu sách: ${theMuon.soHieuSach}")
            println("Thông tin sinh viên:")
            println(" - Họ tên: ${theMuon.sinhVien.hoTen}")
            println(" - Tuổi: ${theMuon.sinhVien.tuoi}")
            println(" - Lớp: ${theMuon.sinhVien.lop}")
            println()
        }
    }
}

fun main() {
    val quanLyTheMuon = QuanLyTheMuon()
    val scanner = Scanner(System.`in`)

    while (true) {
        println("Chọn chức năng:")
        println("1. Thêm thẻ mượn sách")
        println("2. Xoá thẻ mượn sách")
        println("3. Hiển thị danh sách thẻ mượn sách")
        println("4. Thoát")

        print("Nhập lựa chọn của bạn: ")
        val luaChon = scanner.nextInt()
        scanner.nextLine() // Đọc newline character

        when (luaChon) {
            1 -> {
                println("Nhập thông tin thẻ mượn sách:")
                print("Mã phiếu mượn: ")
                val maPhieuMuon = scanner.nextLine()
                print("Ngày mượn: ")
                val ngayMuon = scanner.nextInt()
                scanner.nextLine() // Đọc newline character
                print("Hạn trả: ")
                val hanTra = scanner.nextInt()
                scanner.nextLine() // Đọc newline character
                print("Số hiệu sách: ")
                val soHieuSach = scanner.nextLine()
                print("Thông tin sinh viên:")
                print("Họ tên: ")
                val hoTen = scanner.nextLine()
                print("Tuổi: ")
                val tuoi = scanner.nextInt()
                scanner.nextLine() // Đọc newline character
                print("Lớp: ")
                val lop = scanner.nextLine()

                val sinhVien = SinhVien(hoTen, tuoi, lop)
                val theMuon = TheMuon(maPhieuMuon, ngayMuon, hanTra, soHieuSach, sinhVien)
                quanLyTheMuon.themTheMuon(theMuon)
            }
            2 -> {
                print("Nhập mã phiếu mượn cần xoá: ")
                val maPhieuMuon = scanner.nextLine()
                quanLyTheMuon.xoaTheMuon(maPhieuMuon)
            }
            3 -> {
                quanLyTheMuon.hienThiDanhSach()
            }
            4 -> {
                println("Kết thúc chương trình.")
                return
            }
            else -> println("Lựa chọn không hợp lệ.")
        }
    }
}
