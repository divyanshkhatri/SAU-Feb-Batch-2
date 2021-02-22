import 'react-native-gesture-handler';
import React, {useEffect, Component, useState} from 'react';
import AnimatedSplash from "react-native-animated-splash-screen";
import {LogBox, Image, ImageComponent} from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import DetailsScreen from './src/components/DetailsScreen';
import MainComponent from './src/components/MainComponent';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';

const Tab = createBottomTabNavigator();
const Stack = createStackNavigator();

export default class App extends Component{
  // useEffect(() => {
  //   LogBox.ignoreLogs(['Animated: `useNativeDriver`']);
  // }, []);

  constructor(props) {
    super(props);
    this.state = {
      isLoading: false,
    }
  }

  async componentDidMount() {
    LogBox.ignoreLogs(['Animated: `useNativeDriver`']);
    setTimeout(() => {
      this.setState({ isLoading: true })
    }, 500);
  }



  render() {
    return (
      <AnimatedSplash
          translucent={true}
          isLoaded={this.state.isLoading}
          logoImage={require("./src/assets/images/tmdb1.png")}
          backgroundColor={"black"}
          logoHeight={150}
          logoWidth={150}
      >
        <NavigationContainer>
          <Stack.Navigator initialRouteName = "Main">
              <Stack.Screen 
                name = "Details" 
                component = {DetailsScreen} 
                options= {{headerBackTitleVisible: true, 
                  headerBackTitleVisible: false, 
                  headerTintColor: "white", 
                  headerTitleStyle: {
                  textAlign: "center",
                  marginTop: 0,
                  fontSize: 25,
                  fontFamily: "Poppins-Black",
                  fontWeight: '900',
                  color: "white",
                  },
                  headerLeftContainerStyle: {
                  marginLeft: 10,
                  },
                  headerStyle: {
                  backgroundColor: 'black',
                  borderWidth: 0,
                  elevation: 0,
                  shadowOpacity: 0,
                  borderBottomWidth: 0,
                  }
                }} 
              />
              <Stack.Screen name = "Main" component= {MainComponent} 
                options= {{
                  headerShown: false
              }} 
              />
          </Stack.Navigator>
        </NavigationContainer>
      </AnimatedSplash>
    );
  }
}