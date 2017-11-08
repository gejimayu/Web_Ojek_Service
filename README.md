### YESBOSS - Website Ojek Online Clone
---
##### Tugas 2 IF3110 Pengembangan Aplikasi Berbasis Web
---

#### Deskripsi Singkat

> Simple Clone Ojek Online App based on web using web-service SOAP and REST.

#### Arsitektur Umum Server
![Gambar Arsitektur Umum](arsitektur_umum.png)

#### Anggota Tim
1. [Taufan Mahaputra](http://gitlab.informatika.org/taufanmahaputra) - 13515028
2. [Gianfranco F.H](http://gitlab.informatika.org/gejimayu) - 13515118
3. [Erfandi Suryo Putra](http://gitlab.informatika.org/evansp2612) - 13515145

#### Tools
1. _Back-end :_ Java(using JAX-WS SOAP and Servlet REST)
2. _Database :_ MySQL
3. _Front-end :_ Javascript, HTML, dan CSS 

## Penjelasan

- **Basis data dari sistem yang dibuat.**
    
    Basis data dibagi menjadi dua, yaitu ojekaccount dan ojekonline. Database ojekaccount digunakan untuk manajemen account yang diakses identity service, sementara database ojekonline digunakan untuk manajemen data yang tidak berhubungan dengan account
 
    Database ojekaccount terdiri dari tabel accesstoken yang menyimpan data user_id, token, dan expiretime nya, dan tabel userdata yang menyimpan data username dan password.
    
    Database ojekonline terdiri dari tabel user, driver, pref_location, order_data, user_history, driver_history
- **Konsep *shared session* dengan menggunakan REST.**
    
    Setiap user yang login atau register mendapatkan token. Jika ada user lain yang mengetahui token tersebut, user tersebut dapat menggunakannya untuk mendapatkan session yang sama.
- **Pembangkitan token dan expire time pada sistem yang dibuat**
    
    Token digenerate secara random menggunakan library UUID, lalu token tersebut dimasukkan ke database accesstoken. Expire time, yaitu sejam setelah token dibangkitkan, juga dimasukkan ke database. Saat logout atau saat sudah mencapai expire time, token dihapus
- **Kelebihan dan kelemahan dari arsitektur aplikasi ini, dibandingkan dengan aplikasi monolitik**
    
    Kelebihan dari arsitektur ini adalah service tidak hanya bisa digunakan oleh aplikasi ini, tetapi juga dapat digunakan aplikasi lain sesuai keinginan. Kelemahan dari arsitektur ini adalah lebih sulit diimplementasi

#### Pembagian Tugas

##### <p style="color:green">REST</p>
| No. | REST | NIM |
|---|---|---|
|1| Generate token | 13515028, 13515145 |
|2| Validasi token | 13515118 |
|3| Destory token | 13515118 |
|4| Logout | 13515118 |
|5| Login | 13515028 |
|6| Register | 13515145 |

##### <p style="color:green">SOAP</p>
| No. | SOAP | NIM |
|---|---|---|
|1| validateToken | 13515118 |
|2| findDriver | 13515118 |
|3| getNameUser| 13515118 |
|4| findPrefDriver | 13515118 |
|5| getProfile | 13515118 |
|6| insertOrder | 13515118 |
|7| updateDriver | 13515118 |
|9| insertHistory | 13515118 |
|9| insertUser | 13515118 |
|10| getUserHistory | 13515145 |
|11| getDriverHistory | 13515145 |
|12| hideUserHistory | 13515145 |
|13| hideDriverHistory | 13515145 |
|14| getPicture | 13515145 |
|15| getRatingDetail | 13515028 |
|16| getProfileInfo | 13515028 |
|17| listLocation | 13515028 |
|18| addLocation | 13515028 |
|19| deleteLocation | 13515028 |
|20| saveLocation | 13515028 |

##### <p style="color:green">Web app(JSP)</p>
| No. | Web app(JSP) | NIM |
|---|---|---|
|1| Halaman Login | 13515028 |
|2| Halaman Register| 13515145 |
|3| Halaman Profile | 13515028 |
|4| Halaman Edit Profile | 13515028 |
|5| Halaman Edit Location | 13515028 |
|6| Halaman Select Destination | 13515118 |
|7| Halaman Select Driver | 13515118 |
|8| Halaman Complete Order | 13515118 |
|9| Halaman History Penumpang | 13515145 |
|10| Halaman History Driver | 13515145 |


#### License
----

MIT