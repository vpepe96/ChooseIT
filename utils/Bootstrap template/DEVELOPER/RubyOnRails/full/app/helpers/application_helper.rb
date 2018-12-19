# :nodoc:
module ApplicationHelper
  def left_menu
    left_menu_entries(left_menu_content)
  end

  private

  def selected_locale
    locale = FastGettext.locale
    locale_list.detect {|entry| entry[:locale] == locale}
  end

  def locale_list
    [
      {
        flag: 'us',
        locale: 'en',
        name: 'English (US)',
        alt_name: 'United States'
      },
      {
        flag: 'fr',
        locale: 'fr',
        name: 'Français',
        alt_name: 'France'
      },
      {
        flag: 'es',
        locale: 'es',
        name: 'Español',
        alt_name: 'Spanish'
      },
      {
        flag: 'de',
        locale: 'de',
        name: 'Deutsch',
        alt_name: 'German'
      },
      {
        flag: 'jp',
        locale: 'ja',
        name: '日本語',
        alt_name: 'Japan'
      },
      {
        flag: 'cn',
        locale: 'zh',
        name: '中文',
        alt_name: 'China'
      },
      {
        flag: 'it',
        locale: 'it',
        name: 'Italiano',
        alt_name: 'Italy'
      },
      {
        flag: 'pt',
        locale: 'pt',
        name: 'Portugal',
        alt_name: 'Portugal'
      },
      {
        flag: 'ru',
        locale: 'ru',
        name: 'Русский язык',
        alt_name: 'Russia'
      },
      {
        flag: 'kr',
        locale: 'kr',
        name: '한국어',
        alt_name: 'Korea'
      },
    ]
  end

  def left_menu_entries(entries = [])
    output = ''
    entries.each do |entry|
      children_selected = entry[:children] &&
        entry[:children].any? {|child| current_page?(child[:href]) }
      entry_selected =  current_page?(entry[:href])
      li_class =
      case
        when children_selected
          'open'
        when entry_selected
          'active'
      end
      output +=
        content_tag(:li, class: li_class) do
          subentry = ''
          subentry +=
            link_to entry[:href], title: entry[:title], class: entry[:class], target: entry[:target] do
              link_text = ''
              link_text += entry[:content].html_safe
              if entry[:children]
                if children_selected
                  link_text += '<b class="collapse-sign"><em class="fa fa-minus-square-o"></em></b>'
                else
                  link_text += '<b class="collapse-sign"><em class="fa fa-plus-square-o"></em></b>'
                end
              end

              link_text.html_safe
            end
          if entry[:children]
            if children_selected
              ul_style = 'display: block'
            else
              ul_style = ''
            end
            subentry +=
              "<ul style='#{ul_style}'>" +
                left_menu_entries(entry[:children]) +
                "</ul>"
          end

          subentry.html_safe
        end
    end
    output.html_safe
  end

  def left_menu_content
    [
      {
        href: '#',
        title: _('Dashboard'),
        content: "<i class='fa fa-lg fa-fw fa-home'></i> <span class='menu-item-parent'>" + _('Dashboard') + "</span>",
        children: [
          {
            href: root_path,
            title: _('Dashboard'),
            content: "<span class='menu-item-parent'>" + _('Analytics Dashboard') + "</span>"
          },
          {
            href: dashboard_social_path,
            title: _('Dashboard'),
            content: "<span class='menu-item-parent'>" + _('Social Wall') + "</span>"
          },
        ]
      },
      {
        href: '#',
        content: "<i class='fa fa-lg fa-fw fa-cube txt-color-blue'></i> <span class='menu-item-parent'>" + _('SmartAdmin Intel') + "</span>",
        children: [
          {
            href: smartadmin_intel_app_layouts_path,
            title: _('Dashboard'),
            content: "<i class='fa fa-lg fa-fw fa-gear'></i> <span class='menu-item-parent'>" + _('App Layouts') + "</span>"
          },
          {
            href: smartadmin_intel_prebuilt_skins_path,
            title: _('Dashboard'),
            content: "<i class='fa fa-lg fa-fw fa-picture-o'></i> <span class='menu-item-parent'>" + _('Prebuilt Skins') + "</span>"
          },
          {
            href: smartadmin_intel_app_settings_path,
            title: _('Dashboard'),
            content: "<i class='fa fa-cube'></i> " + _('App Settings') + ""
          },
        ]
      },
      {
        href: outlook_inbox_path,
        content: "<i class='fa fa-lg fa-fw fa-inbox'></i> <span class='menu-item-parent'>" + _('Outlook') + "</span> <span class='badge pull-right inbox-badge margin-right-13'>14</span>",
      },
      {
        href: '#',
        content: "<i class='fa fa-lg fa-fw fa-bar-chart-o'></i> <span class='menu-item-parent'>" + _('Graphs') + "</span>",
        children: [
          {
            href: graphs_flot_chart_path,
            content: _('Flot Chart')
          },
          {
            href: graphs_morris_charts_path,
            content: _('Morris Charts')
          },
          {
            href: graphs_sparklines_path,
            content: _('Sparklines')
          },
          {
            href: graphs_easy_pie_charts_path,
            content: _('EasyPieCharts')
          },
          {
            href: graphs_dygraphs_path,
            content: _('Dygraphs')
          },
          {
            href: graphs_chart_js_path,
            content: _('Chart.js')
          },
          {
            href: graphs_highchart_table_path,
            content: "" + _('HighchartTable') + " <span class='badge pull-right inbox-badge bg-color-yellow'>" + _('new') + "</span>"
          },
        ]
      },
      {
        href: '#',
        content: "<i class='fa fa-lg fa-fw fa-table'></i> <span class='menu-item-parent'>" + _('Tables') + "</span>",
        children: [
          {
            href: tables_normal_tables_path,
            content: _('Normal Tables')
          },
          {
            href: tables_data_tables_path,
            content: "" + _('Data Tables') + " <span class='badge inbox-badge bg-color-greenLight hidden-mobile'>" + _('responsive') + "</span>"
          },
          {
            href: tables_jquery_grid_path,
            content: _('Jquery Grid')
          },
        ]
      },
      {
        href: '#',
        content: "<i class='fa fa-lg fa-fw fa-pencil-square-o'></i> <span class='menu-item-parent'>" + _('Forms') + "</span>",
        children: [
          {
            href: forms_smart_form_elements_path,
            content: _('Smart Form Elements')
          },
          {
            href: forms_smart_form_layouts_path,
            content: _('Smart Form Layouts')
          },
          {
            href: forms_smart_form_validations_path,
            content: _('Smart Form Validation')
          },
          {
            href: forms_bootstrap_form_elements_path,
            content: _('Bootstrap Form Elements')
          },
          {
            href: forms_bootstrap_form_validation_path,
            content: _('Bootstrap Form Validation')
          },
          {
            href: forms_form_plugins_path,
            content: _('Form Plugins')
          },
          {
            href: forms_wizards_path,
            content: _('Wizards')
          },
          {
            href: forms_bootstrap_editors_path,
            content: _('Bootstrap Editors')
          },
          {
            href: forms_dropzone_path,
            content: _('Dropzone')
          },
          {
            href: forms_image_cropping_path,
            content: _('Image Cropping')
          },
          {
            href: forms_ck_editor_path,
            content: _('CK Editor')
          },
        ]
      },
      {
        href: '#',
        content: "<i class='fa fa-lg fa-fw fa-desktop'></i> <span class='menu-item-parent'>" + _('UI Elements') + "</span>",
        children: [
          {
            href: ui_elements_general_elements_path,
            content: _('General Elements')
          },
          {
            href: ui_elements_buttons_path,
            content: _('Buttons')
          },
          {
            href: '#',
            content: _('Icons'),
            children: [
              {
                href: ui_elements_icons_font_awesome_path,
                content: "<i class='fa fa-plane'></i> " + _('Font Awesome') + ""
              },
              {
                href: ui_elements_icons_glyph_icons_path,
                content: "<i class='glyphicon glyphicon-plane'></i> " + _('Glyph Icons') + ""
              },
              {
                href: ui_elements_icons_flags_path,
                content: "<i class='fa fa-flag'></i> " + _('Flags') + ""
              },
            ]
          },
          {
            href: ui_elements_grid_path,
            content: _('Grid')
          },
          {
            href: ui_elements_tree_view_path,
            content: _('Tree View')
          },
          {
            href: ui_elements_nestable_lists_path,
            content: _('Nestable Lists')
          },
          {
            href: ui_elements_jquery_ui_path,
            content: _('JQuery UI')
          },
          {
            href: ui_elements_typography_path,
            content: _('Typography')
          },
          {
            href: '#',
            content: _('Six Level Menu'),
            children: [
              {
                href: '#',
                content: "<i class='fa fa-fw fa-folder-open'></i> " + _('Item #2') + "",
                children: [
                  {
                    href: '#',
                    content: "<i class='fa fa-fw fa-folder-open'></i> " + _('Sub #2.1') + " ",
                    children: [
                      {
                        href: '#',
                        content: "<i class='fa fa-fw fa-file-text'></i> " + _('Item #2.1.1') + "",
                        children: [
                          {
                            href: '#',
                            content: "<i class='fa fa-fw fa-plus'></i> " + _('Expand') + "",
                            children: [
                              {
                                href: '#',
                                content: "<i class='fa fa-fw fa-file-text'></i> " + _('File') + ""
                              },
                            ]
                          },
                        ]
                      },
                    ]
                  },
                ]
              },
              {
                href: '#',
                content: "<i class='fa fa-fw fa-folder-open'></i> " + _('Item #3') + "",
                children: [
                  {
                    href: '#',
                    content: "<i class='fa fa-fw fa-folder-open'></i> " + _('3rd Level') + "",
                    children: [
                      {
                        href: '#',
                        content: "<i class='fa fa-fw fa-file-text'></i> " + _('File') + ""
                      },
                      {
                        href: '#',
                        content: "<i class='fa fa-fw fa-file-text'></i> " + _('File') + ""
                      },
                    ]
                  },
                ]
              },
              {
                href: '#',
                class: 'inactive',
                content: "<i class='fa fa-fw fa-folder-open'></i> " + _('Item #4 (disabled)') + ""
              },
            ]
          },
        ]
      },
      {
        href: widgets_path,
        content: "<i class='fa fa-lg fa-fw fa-list-alt'></i> <span class='menu-item-parent'>" + _('Widgets') + "</span>"
      },
      {
        href: '#',
        content: "<i class='fa fa-lg fa-fw fa-cloud'><em>3</em></i> <span class='menu-item-parent'>" + _('Cool Features!') + "</span>",
        children: [
          {
            href: cool_features_calendar_path,
            content: "<i class='fa fa-lg fa-fw fa-calendar'></i> <span class='menu-item-parent'>" + _('Calendar') + "</span>"
          },
          {
            href: cool_features_gmap_skins_path,
            content: "<i class='fa fa-lg fa-fw fa-map-marker'></i> <span class='menu-item-parent'>" + _('GMap Skins') + "</span><span class='badge bg-color-greenLight pull-right inbox-badge'>9</span>"
          },
        ]
      },
      {
        href: '#',
        content: "<i class='fa fa-lg fa-fw fa-puzzle-piece'></i> <span class='menu-item-parent'>" + _('App Views') + "</span>",
        children: [
          {
            href: app_views_projects_path,
            content: "<i class='fa fa-file-text-o'></i> " + _('Projects') + ""
          },
          {
            href: app_views_blog_path,
            content: "<i class='fa fa-paragraph'></i> " + _('Blog') + ""
          },
          {
            href: app_views_gallery_path,
            content: "<i class='fa fa-picture-o'></i> " + _('Gallery') + ""
          },
          {
            href: '#',
            content: "<i class='fa fa-comments'></i> " + _('Forum Layout') + "",
            children: [
              {
                href: app_views_forum_layout_general_view_path,
                content: _('General View')
              },
              {
                href: app_views_forum_layout_topic_view_path,
                content: _('Topic View')
              },
              {
                href: app_views_forum_layout_post_view_path,
                content: _('Post View')
              },

            ]
          },
          {
            href: app_views_profile_path,
            content: "<i class='fa fa-group'></i> " + _('Profile') + ""
          },
          {
            href: app_views_timeline_path,
            content: "<i class='fa fa-clock-o'></i> " + _('Timeline') + ""
          },
          {
            href: app_views_search_page_path,
            content: "<i class='fa fa-search'></i>  " + _('Search Page') + ""
          },
        ]
      },
      {
        href: '#',
        content: "<i class='fa fa-lg fa-fw fa-shopping-cart'></i> <span class='menu-item-parent'>" + _('E-Commerce') + "</span>",
        children: [
          {
            href: e_commerce_orders_path,
            content: _('Orders')
          },
          {
            href: e_commerce_products_view_path,
            content: _('Products View')
          },
          {
            href: e_commerce_products_detail_path,
            content: _('Products Detail')
          },
        ]
      },
      {
        href: '#',
        content: "<i class='fa fa-lg fa-fw fa-windows'></i> <span class='menu-item-parent'>" + _('Miscellaneous') + "</span>",
        children: [
          {
            href: miscellaneous_pricing_tables_path,
            content: _('Pricing Tables')
          },
          {
            href: miscellaneous_invoice_path,
            content: _('Invoice')
          },
          {
            href: miscellaneous_login_path,
            content: _('Login')
          },
          {
            href: miscellaneous_register_path,
            content: _('Register')
          },
          {
            href: miscellaneous_forgot_password_path,
            content: _('Forgot Password')
          },
          {
            href: miscellaneous_locked_screen_path,
            content: _('Locked Screen')
          },
          {
            href: miscellaneous_error_404_path,
            content: _('Error 404')
          },
          {
            href: miscellaneous_error_500_path,
            content: _('Error 500')
          },
          {
            href: miscellaneous_blank_page_path,
            content: _('Blank Page')
          },
        ]
      },
    ]
  end

end
