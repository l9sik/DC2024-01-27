package com.github.hummel.dc.lab4.repository.impl

import com.github.hummel.dc.lab4.bean.Sticker
import com.github.hummel.dc.lab4.dao.StickerDao
import com.github.hummel.dc.lab4.repository.StickersRepository

class StickersRepositoryImpl(
	private val dao: StickerDao
) : StickersRepository {
	override suspend fun create(item: Sticker): Long? {
		return try {
			dao.create(item)
		} catch (e: Exception) {
			null
		}
	}

	override suspend fun deleteById(id: Long): Boolean = dao.deleteById(id) > 0

	override suspend fun getAll(): List<Sticker?> = dao.getAll()

	override suspend fun getById(id: Long): Sticker? {
		return try {
			dao.getById(id)
		} catch (e: Exception) {
			null
		}
	}

	override suspend fun update(item: Sticker): Boolean = dao.update(item) > 0
}