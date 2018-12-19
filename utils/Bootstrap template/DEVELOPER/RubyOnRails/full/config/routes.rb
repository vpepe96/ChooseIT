Rails.application.routes.draw do
  devise_for :users
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
  root 'dashboard#analytics'
  get 'dashboards/dashboard-social',
      to: 'dashboard#social',
      as: :dashboard_social

  # Smartadmin intel
  get 'smartadmin_intel/app_layouts',
      to: 'smartadmin_intel#app_layouts',
      as: :smartadmin_intel_app_layouts
  get 'smartadmin_intel/app_settings',
      to: 'smartadmin_intel#app_settings',
      as: :smartadmin_intel_app_settings
  get 'smartadmin_intel/prebuilt_skins',
      to: 'smartadmin_intel#prebuilt_skins',
      as: :smartadmin_intel_prebuilt_skins
  get 'outlook/inbox', to: 'outlook#inbox', as: :outlook_inbox

  # AJAX
  get 'ajax/email_compose', to: 'ajax#email_compose', as: :ajax_email_compose
  get 'ajax/email_list', to: 'ajax#email_list', as: :ajax_email_list
  get 'ajax/email_opened', to: 'ajax#email_opened', as: :ajax_email_opened
  get 'ajax/email_reply', to: 'ajax#email_reply', as: :ajax_email_reply
  get 'ajax/demo_widget', to: 'ajax#demo_widget', as: :ajax_demo_widget
  get 'ajax/data_list.json', to: 'ajax#data_list', as: :ajax_data_list
  get 'ajax/notify_mail', to: 'ajax#notify_mail', as: :ajax_notify_mail
  get 'ajax/notify_notifications',
      to: 'ajax#notify_notifications',
      as: :ajax_notify_notifications
  get 'ajax/notify_tasks', to: 'ajax#notify_tasks', as: :ajax_notify_tasks

  # Graphs
  get 'graphs/flot_chart', to: 'graphs#flot_chart', as: :graphs_flot_chart
  get 'graphs/morris_charts',
      to: 'graphs#morris_charts',
      as: :graphs_morris_charts
  get 'graphs/sparklines', to: 'graphs#sparklines', as: :graphs_sparklines
  get 'graphs/easy_pie_charts',
      to: 'graphs#easy_pie_charts',
      as: :graphs_easy_pie_charts
  get 'graphs/dygraphs', to: 'graphs#dygraphs', as: :graphs_dygraphs
  get 'graphs/chart_js', to: 'graphs#chart_js', as: :graphs_chart_js
  get 'graphs/highchart_table',
      to: 'graphs#highchart_table',
      as: :graphs_highchart_table

  # Tables
  get 'tables/normal_tables',
      to: 'tables#normal_tables',
      as: :tables_normal_tables
  get 'tables/data_tables', to: 'tables#data_tables', as: :tables_data_tables
  get 'tables/jquery_grid', to: 'tables#jquery_grid', as: :tables_jquery_grid

  # Forms
  get 'forms/smart_form_elements',
      to: 'forms#smart_form_elements',
      as: :forms_smart_form_elements
  get 'forms/smart_form_layouts',
      to: 'forms#smart_form_layouts',
      as: :forms_smart_form_layouts
  get 'forms/smart_form_validations',
      to: 'forms#smart_form_validations',
      as: :forms_smart_form_validations
  get 'forms/bootstrap_form_elements',
      to: 'forms#bootstrap_form_elements',
      as: :forms_bootstrap_form_elements
  get 'forms/bootstrap_form_validation',
      to: 'forms#bootstrap_form_validation',
      as: :forms_bootstrap_form_validation
  get 'forms/form_plugins', to: 'forms#form_plugins', as: :forms_form_plugins
  get 'forms/wizards', to: 'forms#wizards', as: :forms_wizards
  get 'forms/bootstrap_editors',
      to: 'forms#bootstrap_editors',
      as: :forms_bootstrap_editors
  get 'forms/dropzone', to: 'forms#dropzone', as: :forms_dropzone
  get 'forms/image_cropping',
      to: 'forms#image_cropping',
      as: :forms_image_cropping
  get 'forms/ck_editor', to: 'forms#ck_editor', as: :forms_ck_editor

  # UI Elements
  get 'ui_elements/general_elements',
      to: 'ui_elements#general_elements',
      as: :ui_elements_general_elements
  get 'ui_elements/buttons', to: 'ui_elements#buttons', as: :ui_elements_buttons
  get 'ui_elements/icons/font_awesome',
      to: 'ui_elements#icons_font_awesome',
      as: :ui_elements_icons_font_awesome
  get 'ui_elements/icons/glyph_icons',
      to: 'ui_elements#icons_glyph_icons',
      as: :ui_elements_icons_glyph_icons
  get 'ui_elements/icons/flags',
      to: 'ui_elements#icons_flags',
      as: :ui_elements_icons_flags
  get 'ui_elements/grid', to: 'ui_elements#grid', as: :ui_elements_grid
  get 'ui_elements/tree_view',
      to: 'ui_elements#tree_view',
      as: :ui_elements_tree_view
  get 'ui_elements/nestable_lists',
      to: 'ui_elements#nestable_lists',
      as: :ui_elements_nestable_lists
  get 'ui_elements/jquery_ui',
      to: 'ui_elements#jquery_ui',
      as: :ui_elements_jquery_ui
  get 'ui_elements/typography',
      to: 'ui_elements#typography',
      as: :ui_elements_typography

  # Widgets
  get 'widgets/', to: 'widgets#index', as: :widgets

  # Cool Features
  get 'cool_features/calendar',
      to: 'cool_features#calendar',
      as: :cool_features_calendar
  get 'cool_features/gmap_skins',
      to: 'cool_features#gmap_skins',
      as: :cool_features_gmap_skins

  # App Views
  get 'app_views/projects', to: 'app_views#projects', as: :app_views_projects
  get 'app_views/blog', to: 'app_views#blog', as: :app_views_blog
  get 'app_views/gallery', to: 'app_views#gallery', as: :app_views_gallery
  get 'app_views/forum_layout_general_view',
      to: 'app_views#forum_layout_general_view',
      as: :app_views_forum_layout_general_view
  get 'app_views/forum_layout_topic_view',
      to: 'app_views#forum_layout_topic_view',
      as: :app_views_forum_layout_topic_view
  get 'app_views/forum_layout_post_view',
      to: 'app_views#forum_layout_post_view',
      as: :app_views_forum_layout_post_view
  get 'app_views/profile', to: 'app_views#profile', as: :app_views_profile
  get 'app_views/timeline', to: 'app_views#timeline', as: :app_views_timeline
  get 'app_views/search_page',
      to: 'app_views#search_page',
      as: :app_views_search_page

  # E-Commerce
  get 'e_commerce/orders', to: 'e_commerce#orders', as: :e_commerce_orders
  get 'e_commerce/products_view',
      to: 'e_commerce#products_view',
      as: :e_commerce_products_view
  get 'e_commerce/products_detail',
      to: 'e_commerce#products_detail',
      as: :e_commerce_products_detail

  # Miscellaneous
  get 'miscellaneous/pricing_tables',
      to: 'miscellaneous#pricing_tables',
      as: :miscellaneous_pricing_tables
  get 'miscellaneous/invoice',
      to: 'miscellaneous#invoice',
      as: :miscellaneous_invoice
  get 'miscellaneous/login',
      to: 'miscellaneous#login',
      as: :miscellaneous_login
  get 'miscellaneous/register',
      to: 'miscellaneous#register',
      as: :miscellaneous_register
  get 'miscellaneous/forgot_password',
      to: 'miscellaneous#forgot_password',
      as: :miscellaneous_forgot_password
  get 'miscellaneous/locked_screen',
      to: 'miscellaneous#locked_screen',
      as: :miscellaneous_locked_screen
  get 'miscellaneous/error_404',
      to: 'miscellaneous#error_404',
      as: :miscellaneous_error_404
  get 'miscellaneous/error_500',
      to: 'miscellaneous#error_500',
      as: :miscellaneous_error_500
  get 'miscellaneous/blank_page',
      to: 'miscellaneous#blank_page',
      as: :miscellaneous_blank_page

  # Smart chat API
  get 'smart_chat_api/',
      to: 'smart_chat_api#index',
      as: :smart_chat_api

  # Misc methods
  get '/home/set_locale', to: 'home#set_locale', as: :home_set_locale

  # CK editor
  mount Ckeditor::Engine => '/ckeditor'
end
