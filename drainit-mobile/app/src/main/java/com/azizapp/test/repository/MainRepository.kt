package com.azizapp.test.repository

import com.azizapp.test.api.MasyarakatService
import com.azizapp.test.model.*
import com.azizapp.test.model.pengaduanvote.PengaduanWithVote
import com.azizapp.test.model.vote.Vote
import com.azizapp.test.model.vote.VoteResponse
import com.azizapp.test.model.vote.VoteUpdate
import com.azizapp.test.utill.Resource
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val masyarakatService: MasyarakatService
) {

    suspend fun masyarakatLogin(masyarakat: Masyarakat): Resource<MasyarakatLoginResponse> {
        masyarakatService.loginMasyarakat(masyarakat).let { response ->
            if (response.isSuccessful) {
                response.body()?.let { return Resource.Success(it) }
            }
            return Resource.Error(response.message())
        }
    }

    suspend fun getMasyarakatData(bearer: String): Resource<ProfileMasyarakat> {
        masyarakatService.profileMasyarakat(bearer).let { response ->
            if (response.isSuccessful) {
                response.body()?.let { return Resource.Success(it) }
            }
            return Resource.Error(response.message())
        }
    }

    suspend fun masyarakatDaftar(masyarakatDaftar: MasyarakatDaftar): Resource<MasyarakatDaftarResponse> {
        masyarakatService.daftarMasyarakat("application/json", masyarakatDaftar).let { response ->
            if (response.isSuccessful) {
                response.body()?.let { return Resource.Success(it) }
            }
            return Resource.Error(response.message())
        }
    }

    suspend fun masyarakatLaporan(
        bearer: String,
        dataPengaduanMasyarakat: DataPengaduanMasyarakat
    ): Resource<DataPengaduanMasyarakat> {
        masyarakatService.pengaduanMasyarakat(
            bearer,
            "application/json",
            dataPengaduanMasyarakat
        ).let { response ->
            if (response.isSuccessful) {
                response.body()?.let {
                    return Resource.Success(it)
                }
            }
            return Resource.Error(response.message())
        }
    }


    suspend fun masyarakatLaporanAnonymouse(
        dataPengaduanMasyarakat: DataPengaduanMasyarakat
    ): Resource<DataPengaduanMasyarakat> {
        masyarakatService.pengaduanMasyarakatAnonim(
            "application/json",
            dataPengaduanMasyarakat
        ).let { response ->
            if (response.isSuccessful) {
                response.body()?.let {
                    return Resource.Success(it)
                }
            }
            return Resource.Error(response.message())
        }
    }

    suspend fun editMasyarakat(
        bearer: String,
        editMasyarakatRequest: EditMasyarakatRequest
    ): Resource<EditMasyarakatResponse> {
        masyarakatService.editPassword(bearer, editMasyarakatRequest).let { response ->
            if (response.isSuccessful) {
                response.body()?.let { return Resource.Success(it) }
            }
            return Resource.Error(response.message())
        }
    }

    suspend fun getPengaduanMasyarakat(bearer: String): Resource<PengaduanResponse> {
        masyarakatService.riwayatMasyarakat(bearer).let { response ->
            if (response.isSuccessful) {
                response.body()?.let { return Resource.Success(it) }
            }
            return Resource.Error(response.message())
        }
    }

    suspend fun getTitikBanjir(): Resource<TitikBanjirResponse> {
        masyarakatService.titikBanjir().let { response ->
            if (response.isSuccessful) {
                response.body()?.let { return Resource.Success(it) }
            }
            return Resource.Error(response.message())
        }
    }

    suspend fun getTitikTersumbat(): Resource<TitikTersumbatResponse> {
        masyarakatService.titikTersumbat().let { response ->
            if (response.isSuccessful) {
                response.body()?.let { return Resource.Success(it) }
            }
            return Resource.Error(response.message())
        }
    }

    suspend fun getSemuaLaporan(): Resource<PengaduanResponse> {
        masyarakatService.semuaLaporan().let { response ->
            if (response.isSuccessful) {
                response.body()?.let { return Resource.Success(it) }
            }
            return Resource.Error(response.message())
        }
    }

    suspend fun getSemuaLaporanVote(bearer: String): Resource<PengaduanWithVote> {
        masyarakatService.semuaLaporanVote(bearer).let { response ->
            if (response.isSuccessful) {
                response.body()?.let { return Resource.Success(it) }
            }
            return Resource.Error(response.message())
        }
    }

    suspend fun vote(bearer: String, vote: Vote): Resource<VoteResponse> {
        masyarakatService.firstVote(bearer, vote).let { response ->
            if (response.isSuccessful) {
                response.body()?.let { return Resource.Success(it) }
            }
            return Resource.Error(response.message())
        }
    }

    suspend fun voteUpdate(
        idPengaduan: String,
        bearer: String,
        vote: VoteUpdate
    ): Resource<VoteResponse> {
        masyarakatService.updateVote(idPengaduan, bearer, vote).let { response ->
            if (response.isSuccessful) {
                response.body()?.let { return Resource.Success(it) }
            }
            return Resource.Error(response.message())
        }
    }
}