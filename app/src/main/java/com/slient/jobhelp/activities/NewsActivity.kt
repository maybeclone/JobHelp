package com.slient.jobhelp.activities

import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Xml
import android.view.View
import com.slient.jobhelp.R
import com.slient.jobhelp.adapters.NewsAdapter
import com.slient.jobhelp.callbacks.NewsCallback
import com.slient.jobhelp.configs.ConfigIntent
import com.slient.jobhelp.models.data.ItemNews
import kotlinx.android.synthetic.main.activity_news.*
import org.xml.sax.InputSource
import org.xmlpull.v1.XmlPullParser
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import javax.xml.parsers.DocumentBuilderFactory

class NewsActivity : AppCompatActivity(), NewsCallback {

    lateinit var adapter : NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        newsToolbar.setTitle(getString(R.string.title_toolbar_news))
        setSupportActionBar(newsToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        newsToolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        adapter = NewsAdapter(this)
        newsRecyclerView.adapter = adapter
        NewsAsyncTask()
                .execute("https://thanhnien.vn/rss/giao-duc/tuyen-sinh/2018.rss")
    }

    override fun callback(url: String?) {
        val intent = Intent(this, DetailNewsActivity::class.java)
        intent.putExtra(ConfigIntent.EXTRA_URL_NEWS, url)
        startActivity(intent)
    }

    inner class NewsAsyncTask: AsyncTask<String, Void, ArrayList<ItemNews>>(){

        override fun onPreExecute() {
            super.onPreExecute()
            loadingRSSProgressBar.visibility = View.VISIBLE
        }

        override fun doInBackground(vararg params: String?): ArrayList<ItemNews> {
            val url = URL(params[0])

            return parseXML(url.openConnection().getInputStream())
        }

        override fun onPostExecute(result: ArrayList<ItemNews>?) {
            super.onPostExecute(result)
            loadingRSSProgressBar.visibility = View.GONE
            adapter.swapList(result)
        }

        fun parseXML(inputStream: InputStream): ArrayList<ItemNews>{
            val xmlPullParser = Xml.newPullParser()
            xmlPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false)
            xmlPullParser.setInput(inputStream, null)

            val arrayList = ArrayList<ItemNews>()
            var isItem = false
            var title = ""
            var dateTime = ""
            var url = ""
            var srcImage = ""
            xmlPullParser.nextTag()
            while (xmlPullParser.next() != XmlPullParser.END_DOCUMENT){
                val eventType = xmlPullParser.eventType

                val name = xmlPullParser.name
                if(name == null)
                    continue

                if(eventType == XmlPullParser.END_TAG){
                    if(name.equals("item")){
                        isItem = false
                    }
                    continue
                }

                if(eventType == XmlPullParser.START_TAG){
                    if(name.equals("item")){
                        isItem = true
                        continue
                    }
                }

                var result = ""
                if(xmlPullParser.next() == XmlPullParser.TEXT){
                    result = xmlPullParser.text
                    xmlPullParser.nextTag()
                }

                if(name.equals("title")){
                    title = result
                } else if(name.equals("link")){
                    url = result
                } else if(name.equals("pubDate")){
                    dateTime = result
                } else if(name.equals("description")){
                    val arr = result.split(" ")[5].split("\"")
                    if(arr.size == 3){
                        srcImage = arr[1]
                    } else {
                        srcImage = result
                    }
                }

                if(title != "" && url != "" && dateTime != "" && srcImage != ""){
                    if(isItem){
                        val itemNews = ItemNews(title, url, dateTime, srcImage)
                        arrayList.add(itemNews)
                    }
                    title = ""
                    url = ""
                    dateTime = ""
                    srcImage = ""
                    isItem = false
                }

            }
            return arrayList
        }

    }
}
