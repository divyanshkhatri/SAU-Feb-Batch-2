import React, {Component} from 'react';
import { NavigationContainer } from '@react-navigation/native';
import TopRatedComponent from '../TopRatedComponent';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import HomeScreen from '../HomeScreen';
import {Image} from 'react-native';
import NowPlayingComponent from '../NowPlayingComponent';

const Tab = createBottomTabNavigator();

function MainComponent() {
  return (
    <Tab.Navigator 
            initialRouteName="Home" 
            tabBarOptions = {{
            tabStyle: {
                backgroundColor: "black",
                paddingBottom: 30,
            },
            labelStyle: {
                fontFamily: "Poppins-SemiBold",
                fontSize: 12,
            },
            safeAreaInsets: {
                bottom: 0,
            },
            activeTintColor: "white",
            style: {
                height: 70,
                borderTopWidth: 0,
            },
        }}
        screenOptions={({ route }) => ({
        tabBarIcon: ({ focused }) => {
            if (route.name === 'Home') {
                if(focused) return <Image style = {{tintColor: "white"}} source = {require("../../assets/images/home.png")} />;
                else return <Image style = {{tintColor: "gray"}} source = {require("../../assets/images/home.png")} />;
            } else if (route.name === 'Top Rated') {
                if(focused) return <Image style = {{tintColor: "white", width: 24, height: 24,}} source = {require("../../assets/images/star.png")} />;
                else return <Image style = {{tintColor: "gray", width: 24, height: 24,}} source = {require("../../assets/images/star.png")} />
            } else if (route.name === 'Now Playing') {
              if(focused) return <Image style = {{tintColor: "white", width: 24, height: 24,}} source = {require("../../assets/images/video.png")} />;
              else return <Image style = {{tintColor: "gray", width: 24, height: 24,}} source = {require("../../assets/images/video.png")} />
          } 
        },
        })}
      >
        <Tab.Screen name = "Home" component = {HomeScreen} options = {{ headerShown: false}} />
        <Tab.Screen name = "Now Playing" component = {NowPlayingComponent} />
        <Tab.Screen 
          name = "Top Rated" 
          component = {TopRatedComponent}
        />

    </Tab.Navigator>
  );
}

export default MainComponent;