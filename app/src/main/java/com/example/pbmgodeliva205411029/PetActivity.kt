package com.example.pbmgodeliva205411029
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class PetActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var newArrayList : ArrayList<Pet>
    private lateinit var tempArrayList : ArrayList<Pet>
    lateinit var petName : Array<String>
    lateinit var petImageId : Array<Int>
    lateinit var petCharacter : Array<String>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet)

        petName = arrayOf(
            "Noir",
            "Joko",
            "Gato",
            "Mao",
            "Pytho",
            "Neko",
            "Acle"
        )

        petImageId = arrayOf(
            R.drawable.noir,
            R.drawable.joko,
            R.drawable.gato,
            R.drawable.mao,
            R.drawable.pytho,
            R.drawable.neko,
            R.drawable.acle
        )

        petCharacter = arrayOf(
            "Anjing yang ada di rumah ini",
            "Joko sudah steril dan hobi mengganggu kakaknya yang lain",
            "Anti mencuri dan tidak makan selain makanannya sendiri",
            "Hobi mencuri makanan manusia dan makanannya Noir",
            "Putri Solo dalam wujud kucing",
            "Sulit dipegang jika bukan dari dirinya sendiri",
            "Sudah besar, jadi jarang di rumah"
        )

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)


        newArrayList = arrayListOf<Pet>()
        tempArrayList = arrayListOf<Pet>()
        getPetData()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item,menu)
        val item = menu?.findItem(R.id.search_action)
        val searchView = item?.actionView as SearchView

        // set search view in action bar
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            // if click the enter button
            override fun onQueryTextSubmit(query: String?): Boolean {
                tempArrayList.clear()
                val searchText = query!!.toLowerCase(Locale.getDefault())
                if (searchText.isNotEmpty()){
                    newArrayList.forEach {
                        if (it.petName.toLowerCase(Locale.getDefault()).contains(searchText)){
                            tempArrayList.add(it)
                        }
                    }
                    recyclerView.adapter!!.notifyDataSetChanged()
                }else{
                    tempArrayList.clear()
                    tempArrayList.addAll(newArrayList)
                    recyclerView.adapter!!.notifyDataSetChanged()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                tempArrayList.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if (searchText.isNotEmpty()){
                    newArrayList.forEach {
                        if (it.petName.toLowerCase(Locale.getDefault()).contains(searchText)){
                            tempArrayList.add(it)
                        }
                    }
                    recyclerView.adapter!!.notifyDataSetChanged()
                }else{
                    tempArrayList.clear()
                    tempArrayList.addAll(newArrayList)
                    recyclerView.adapter!!.notifyDataSetChanged()
                }
                return false
            }
        })

        return super.onCreateOptionsMenu(menu)
    }

    private fun getPetData() {
        for(i in petImageId.indices){
            val pet = Pet(petImageId[i],petName[i])
            newArrayList.add(pet)
        }
        tempArrayList.addAll(newArrayList)


        val adapter = PetAdapter(tempArrayList)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : PetAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                println("nama "+newArrayList[position].petName)
                println("nama "+newArrayList[position].petImage)
                println("nama "+petCharacter[position])

                //  Toast.makeText(this@MainActivity,"You Clicked on item no. $position",Toast.LENGTH_SHORT).show()

                val intent = Intent(this@PetActivity,PetDetailActivity::class.java)
                intent.putExtra("petName",newArrayList[position].petName)
                intent.putExtra("petImage",newArrayList[position].petImage)
                intent.putExtra("petCharacter",petCharacter[position])
                startActivity(intent)
            }
        })
    }

    fun back() {
        val i = Intent(this, MenuActivity::class.java)
        startActivity(i)
    }

    override fun onBackPressed() {
        back()
    }
}