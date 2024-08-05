// i18next
import i18n from 'i18next';

// initReactI18next
import {initReactI18next} from 'react-i18next';

// i18n.use()
i18n.use(initReactI18next).init({
    resources: {
        en:
            {
                translations: {
                    'home': 'Home',
                    'about': 'About',
                    'to_do': 'To Do List',
                    'newspaper': 'Newspaper',
                    'contact': 'Contact',
                    'login': 'Login',
                    'register': 'Register',
                    'search': 'Search',
                    'create': 'Create',
                    'create_all': 'Multiple data create',
                    'delete_all': 'All Delete',
                    'update':"Update",
                    'show':"Show",
                    'date':'Date',
                    'delete':"Delete",
                    'to_do_list': 'To Do List',
                    'to_do_update': 'To Do Update',
                    'to_do_view': 'To Do View',
                    'to_do_create': 'To Do Create',

                    'id':'id',
                    'to_do_content':'To Do Content',
                    'is_read':" are you is read requirement sözleşme ?",
                    'cleaner_form':"Form Cleaner",
                    'submit_to_do':"Save Task",
                }
            },
        tr:
            {
                translations: {
                    'home': 'Anasayfa',
                    'about': 'Hakkımızda',
                    'to_do': 'Yapılacaklar',
                    'newspaper': 'Haberler',
                    'contact': 'İletişim',
                    'login': 'Giriş',
                    'register': 'Üye Ol',
                    'search': 'Arama',
                    'create': 'Ekle',
                    'create_all': 'Çoklu veri ekle',
                    'delete_all': 'Hepsini Sil',
                    'update':"Güncelle",
                    'show':"Göster",
                    'date':"Tarih",
                    'delete':"Sil",
                    'to_do_list': 'Yapılacaklar Listesi',
                    'to_do_update': 'Yapılacaklar Güncelleme',
                    'to_do_view': 'Yapılacakları Göster',
                    'to_do_create': 'Yeni Yapılacak Görev Oluştur',
                    'id':'id',
                    'to_do_content':'Yapılacak Görev Adı',
                    'is_read':"Gerekli Sözleşmeyi okunuz mu ?",
                    'cleaner_form':"Form temizle",
                    'submit_to_do':"Görevi Kaydet",
                }
            }
    },
    fallbackLng: 'tr',    //default olarak Türkçe (tr)
    ns: ['translations'], //kelimeleri nerede alsın
    defaultNS: 'translations',
    keySeparator: false,
    interpolation: {escapeValue: false, formatSeparator: ','},
    react: {
        wait: true
    }
});

// EXPORT
export default i18n;