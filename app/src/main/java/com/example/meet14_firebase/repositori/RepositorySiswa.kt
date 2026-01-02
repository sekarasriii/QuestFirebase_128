package com.example.meet14_firebase.repositori

import com.example.meet14_firebase.modeldata.Siswa
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import java.lang.Exception

interface RepositorySiswa {
    suspend fun getDataSiswa(): List<Siswa>
    suspend fun postDataSiswa(siswa: Siswa)
    suspend fun updateSiswa(siswa: Siswa)
    suspend fun deleteSiswa(siswaId: Long)
    suspend fun getSatuSiswa(id: Long): Siswa
}

class FirebaseRepositorySiswa : RepositorySiswa {
    private val db = FirebaseFirestore.getInstance()
    private val collection = db.collection("siswa")

    override suspend fun getDataSiswa(): List<Siswa> {
        return try {
            collection.get().await().documents.map { doc ->
                Siswa(
                    id = doc.getLong("id")?.toLong() ?: 0,
                    nama = doc.getString("nama") ?: "",
                    alamat = doc.getString("alamat") ?: "",
                    telpon = doc.getString("telpon") ?: ""
                )
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun postDataSiswa(siswa: Siswa) {
        try {
            val docRef = if (siswa.id == 0L) {
                collection.document()
            } else {
                collection.document(siswa.id.toString())
            }

            val data = hashMapOf(
                "id" to (siswa.id.takeIf { it != 0L } ?: docRef.id.hashCode().toLong()),
                "nama" to siswa.nama,
                "alamat" to siswa.alamat,
                "telpon" to siswa.telpon
            )
            docRef.set(data).await()
        } catch (e: Exception) {
            throw e
        }
    }

    // Perbaikan 1: Implementasi fungsi updateSiswa yang tadinya hilang
    override suspend fun updateSiswa(siswa: Siswa) {
        try {
            collection.document(siswa.id.toString())
                .set(siswa)
                .await()
        } catch (e: Exception) {
            throw e
        }
    }

    // Perbaikan 2: Mengganti 'firestore' menjadi 'db' (atau gunakan 'collection' langsung)
    override suspend fun deleteSiswa(siswaId: Long) {
        try {
            collection.document(siswaId.toString())
                .delete()
                .await()
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getSatuSiswa(id: Long): Siswa {
        return try {
            val doc = collection.document(id.toString()).get().await()
            Siswa(
                id = doc.getLong("id")?.toLong() ?: 0,
                nama = doc.getString("nama") ?: "",
                alamat = doc.getString("alamat") ?: "",
                telpon = doc.getString("telpon") ?: ""
            )
        } catch (e: Exception) {
            throw e
        }
    }

}
