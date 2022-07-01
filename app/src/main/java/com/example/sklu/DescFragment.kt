package com.example.sklu

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_desc.*

class DescFragment(val homeActivity: HomeActivity) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_desc, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = "<b>SIKAP</b> <br>" +
                "<b>CPL-1</b>\t\t\t\t: Bertakwa kepada Tuhan Yang Maha Esa dan mampu menunjukkan sikap religius <br>" +
                "<b>CPL-2</b>\t\t\t\t: Menjunjung tinggi nilai kemanusiaan dalam menjalankan tugas berdasarkan agama, moral, dan etika <br>" +
                "<b>CPL-3</b>\t\t\t\t: Dapat berperan sebagai warga negara yang bangga dan cinta tanah air, memiliki nasionalisme, serta rasa tanggungjawab pada negara dan bangsa <br>" +
                "<b>CPL-4</b>\t\t\t\t: Dapat berkontribusi dalam peningkatan mutu kehidupan bermasyarakat, berbangsa, dan bernegara berdasarkan Pancasila <br>" +
                "<b>CPL-5</b>\t\t\t\t: Dapat berkontribusi dalam peningkatan mutu kehidupan bermasyarakat, berbangsa, dan bernegara berdasarkan Pancasila <br>" +
                "<b>CPL-6</b>\t\t\t\t: Dapat menghargai keanekaragaman budaya, pandangan, agama, dan kepercayaan, serta pendapat atau temuan orisinal orang lain <br>" +
                "<b>CPL-7</b>\t\t\t\t: Taat hukum dan disiplin dalam kehidupan bermasyarakat dan bernegara <br>" +
                "<b>CPL-8</b>\t\t\t\t: Menunjukkan sikap bertanggung jawab atas pekerjaan di bidang keahliannya secara mandiri<br>" +
                "<b>CPL-9</b>\t\t\t\t: Menginternalisasi nilai, norma, dan etika akademik <br>" +
                "<b>CPL-10</b>\t\t\t: Menginternalisasi semangat kemandirian, kejuangan, dan kewirausahaan <br>" +
                "<b>PENGETAHUAN</b> <br>" +
                "<b>CPL-11</b>\t\t\t:Menguasai prinsip dan metode matematika untuk menyelesaikan masalah komputasi <br>" +
                "<b>CPL-12</b>\t\t\t:Menguasai prinsip pengembangan algoritma dan berbagai konsep bahasa pemrograman untuk penyelesaian masalah <br>" +
                "<b>CPL-13</b>\t\t\t:Menguasai konsep dan prinsip-prinsip sistem cerdas untuk pengembangan aplikasi sistem cerdas di berbagai bidang <br>" +
                "<b>CPL-14</b>\t\t\t:Menguasai konsep-konsep dasar pengembangan perangkat lunak, memiliki kecakapan yang berhubungan dengan proses pengembangan perangkat lunak, serta mampu membuat program untuk meningkatkan efektivitas penggunaan komputer untuk memecahkan masalah <br>" +
                "<b>CPL-15</b>\t\t\t:Menguasai konsep arsitektur dan organisasi komputer serta memanfaatkannya untuk menunjang aplikasi komputer <br>" +
                "<b>CPL-16</b>\t\t\t:Memahami prinsip dasar sistem jaringan komputer untuk mengembangkan aplikasi berbasis jaringan dengan menerapkan manajemen informasi dan keamanan jaringan <br>" +
                "<b>CPL-17</b>\t\t\t:Memiliki pengetahuan akan perkembangan teknologi terkini dan cara pemanfaatannya di berbagai bidang  <br>" +
                "<b>KETERAMPILAN UMUM </b><br>" +
                "<b>CPL-18</b>\t\t\t:Mampu menerapkan pemikiran logis, kritit sistematis, dan inovatif dalam konteks pengembangan atau implementasi ilmu pengetahuan dan Teknologi yang memperhatikan dan menerapkan nilai humaniora yang sesuai dengan bidang keahliannya <br>" +
                "<b>CPL-19</b>\t\t\t:Mampu menunjukkan kinerja mandiri, bermutu, dan terukur <br>" +
                "<b>CPL-20</b>\t\t\t:Mampu mengkaji implikasi pengembangan atau implementasi ilmu pengetahuan teknologi yang memperhatikan dan menerapkan nilai humaniora sesuai keahliannya berdasarkan kaidah, tata cara, dan etika ilmiah dalam rangka menghasilkan solusi, gagasan, desain, atau kritik seni <br>" +
                "<b>CPL-21</b>\t\t\t:Menyusun deskripsi saintifik hasil kajiannya dalam bentuk skripsi atau laporan tugas akhir dan mengunggahnya dalam laman perguruan tinggi <br>" +
                "<b>CPL-22</b>\t\t\t:Mampu mengambil keputusan secara tepat dalam konteks penyelesaian masalah di bidang keahliannya berdasarkan hasil analisis informasi dan data<br>" +
                "<b>CPL-23</b>\t\t\t:Mampu memelihara dan mengembangkan jaringan kerja dengan pembimbing, kolega, dan sejawat, baik di dalam maupun di luar lembaganya <br>" +
                "<b>CPL-24</b>\t\t\t:Mampu bertanggung jawab atas pencapaian hasil kerja kelompok dan melakukan supervisi dan evaluasi terhadap penyelesaian pekerjaan yang ditugaskan kepada pekerja yang berada di bawah tanggung jawabnya <br>" +
                "<b>CPL-25</b>\t\t\t:Mampu melakukan proses evaluasi diri kelompok kerja yang berada di bawah tanggung jawabnya dan mampu mengelola pembelajaran secara mandiri <br>" +
                "<b>CPL-26</b>\t\t\t:Mampu mendokumentasikan, menyimpan, mengamankan, dan menentukan kembali data untuk menjamin kesahihan dan mencegah plagiasi <br>" +
                "<b>CPL-27</b>\t\t\t:Memiliki kemampuan (pengelolaan) manajerial tim dan kerja sama (team work), manajemen diri, mampu berkomunikasi baik lisan maupun tertulis dengan baik dan mampu melakukan presentasi  <br>" +
                "<b>KETERAMPILAN KHUSUS</b> <br>" +
                "<b>CPL-28</b>\t\t\t:Mampu menerapkan kewirausahaan berbasis teknologi informasi dan komunikasi <br>" +
                "<b>CPL-29</b>\t\t\t:Mampu membuat dan mengintegrasikan aplikasi berbasis desktop, web, atau mobile yang berestetika, komunikatif, dinamis, dan interaktif <br>" +
                "<b>CPL-30</b>\t\t\t:Mampu membangun intelligent systems dan aplikasinya untuk mempermudah kehidupan manusia serta menciptakan peluang wirausaha <br>" +
                "<b>CPL-31</b>\t\t\t:Mampu memproses dan menganalisis permasalahan yang berhubungan dengan big data dan mengimplementasikan hasil analisis tersebut dalam suatu aplikasi inovatif yang menunjang kewirausahaan di bidang teknologi informas <br>" +
                "<b>CPL-32</b>\t\t\t:Mampu membuat game yang memiliki gameplay dan fitur menarik sesuai dengan aspek desain sehingga memiliki nilai jual baik berdasarkan umpan balik dari konsumen <br>" +
                "<b>CPL-33</b>\t\t\t:Mampu menciptakan rintisan wirausaha berbasis teknologi terkini yang tepat guna untuk menyelesaikan permasalahan dan memberikan dampak positif bagi masyarakat "
        var sp = Html.fromHtml(text)
        textDesc.text = sp

    }
}